package org.lyflexi.basicdebug.task;


import org.lyflexi.basicdebug.entity.vo.LoginUserVo;
import org.lyflexi.basicdebug.holder.UserContextHolder;

/**
 * @Description:
 * @Author: lyflexi
 * @project: mybatis-plus-practice
 * @Date: 2024/10/12 10:02
 */

public abstract class AbstractJobTask {

    /**
     * 设置当前任务上线文：
     *      1-用户上下文
     *      2-切换数据源
     * @param factoryCode 工厂编码
     * @param tenantId 租户ID
     */
    public void setContext (String factoryCode, String tenantId) {
        UserContextHolder.getInstance().setContext(LoginUserVo.buildAdminUser(factoryCode, tenantId));
//        TenantContext.getInstance().setCurrentTenant(tenantId);
    }

    /**
     * 清空当前任务上线文：
     *      1-用户上下文
     *      2-切换数据源
     */
    public void clearContext () {
        UserContextHolder.getInstance().clear();
//        TenantContext.getInstance().clear();
    }
}