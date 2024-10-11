
数据库初始状态，version=0

![Snipaste_2024-10-11_16-16-37.png](pics%2FSnipaste_2024-10-11_16-16-37.png)

测试请求：http://{{ip}}:{{port}}/user/optimistic/1 
测试代码：模拟两次乐观锁更新
```java
    @RequestMapping(path = "/optimistic/{id}", method = RequestMethod.GET)
    public Boolean optimistic(@PathVariable Long id)
    {
        UserPo user = userService.getById(id);
        int version = user.getVersion();
        user.setPassword("new password");
        user.setVersion(version);
        boolean b = userService.updateById(user);
        System.out.println("成功与否： "+b);

        user = userService.getById(id);
        version = user.getVersion();
        user.setPassword("new password");
        user.setVersion(version);
        b = userService.updateById(user);
        System.out.println("成功与否： "+b);

        return true;
    }
```

乐观锁日志如下：很显然结果是正确的，先查询，再更新，更新时帮我们加了版本号的条件。
```shell
JDBC Connection [HikariProxyConnection@1636600431 wrapping org.postgresql.jdbc.PgConnection@4eaf7902] will not be managed by Spring
==>  Preparing: SELECT id,name,code,age,data_status,password,version,add_time,edit_time,add_user_code,add_user_name,edit_user_code,edit_user_name FROM public.user WHERE id=? AND data_status=0
==> Parameters: 1(Long)
<==    Columns: id, name, code, age, data_status, password, version, add_time, edit_time, add_user_code, add_user_name, edit_user_code, edit_user_name
<==        Row: 1, zs, zs, 18, 0, 123456, 0, null, null, null, null, null, null
<==      Total: 1
Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@6f4b69f6]
Creating a new SqlSession
SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@5eca9c54] was not registered for synchronization because synchronization is not active
2024-10-11T16:14:53.763+08:00  INFO 25112 --- [nio-8080-exec-3] o.l.d.config.MyMetaObjectHandler         : 开始更新填充...
2024-10-11T16:14:53.766+08:00  INFO 25112 --- [nio-8080-exec-3] o.l.d.config.MyMetaObjectHandler         : 更新填充完成...
JDBC Connection [HikariProxyConnection@494189083 wrapping org.postgresql.jdbc.PgConnection@4eaf7902] will not be managed by Spring
==>  Preparing: UPDATE public.user SET name=?, code=?, age=?, password=?, version=?, edit_time=?, edit_user_code=?, edit_user_name=? WHERE id=? AND version=? AND data_status=0
==> Parameters: zs(String), zs(String), 18(Integer), new password(String), 1(Integer), 2024-10-11T16:14:53.763812900(LocalDateTime), mockUser(String), mockUser(String), 1(Long), 0(Integer)
<==    Updates: 1
Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@5eca9c54]
成功与否： true


Creating a new SqlSession
SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@34df08f3] was not registered for synchronization because synchronization is not active
JDBC Connection [HikariProxyConnection@444323988 wrapping org.postgresql.jdbc.PgConnection@4eaf7902] will not be managed by Spring
==>  Preparing: SELECT id,name,code,age,data_status,password,version,add_time,edit_time,add_user_code,add_user_name,edit_user_code,edit_user_name FROM public.user WHERE id=? AND data_status=0
==> Parameters: 1(Long)
<==    Columns: id, name, code, age, data_status, password, version, add_time, edit_time, add_user_code, add_user_name, edit_user_code, edit_user_name
<==        Row: 1, zs, zs, 18, 0, new password, 1, null, 2024-10-11 16:14:53.763813, null, null, mockUser, mockUser
<==      Total: 1
Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@34df08f3]
Creating a new SqlSession
SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@19020eac] was not registered for synchronization because synchronization is not active
2024-10-11T16:14:53.783+08:00  INFO 25112 --- [nio-8080-exec-3] o.l.d.config.MyMetaObjectHandler         : 开始更新填充...
2024-10-11T16:14:53.784+08:00  INFO 25112 --- [nio-8080-exec-3] o.l.d.config.MyMetaObjectHandler         : 更新填充完成...
JDBC Connection [HikariProxyConnection@952395806 wrapping org.postgresql.jdbc.PgConnection@4eaf7902] will not be managed by Spring
==>  Preparing: UPDATE public.user SET name=?, code=?, age=?, password=?, version=?, edit_time=?, edit_user_code=?, edit_user_name=? WHERE id=? AND version=? AND data_status=0
==> Parameters: zs(String), zs(String), 18(Integer), new password(String), 2(Integer), 2024-10-11T16:14:53.763813(LocalDateTime), mockUser(String), mockUser(String), 1(Long), 1(Integer)
<==    Updates: 1
Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@19020eac]
成功与否： true
postHandle: 请求处理之后，视图渲染之前，可以在这里修改响应数据
afterCompletion: 整个请求完成，可以进行资源清理

```
执行两次乐观更新操作之后,version=2,满足预期

![Snipaste_2024-10-11_16-16-48.png](pics%2FSnipaste_2024-10-11_16-16-48.png)