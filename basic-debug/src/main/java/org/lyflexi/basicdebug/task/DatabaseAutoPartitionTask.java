package org.lyflexi.basicdebug.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: lyflexi
 * @project: mybatis-plus-practice
 * @Date: 2024/10/12 10:02
 */
@Component
@Slf4j
public class DatabaseAutoPartitionTask extends AbstractJobTask {
//    @Autowired
//    private CacheTenantFacade tenantFacade;

    @Autowired
    private DatabaseAutoPartitionJobHandler databaseAutoPartitionHandler;

    /**
     * 基于XXLJOB的定时任务
     */
//    @XxlJob("databaseAutoPartitionTaskHandler")
//    public void databaseAutoPartitionTask() {
//        String jobParam = XxlJobHelper.getJobParam();
//        log.info(">>>>>>>>[databaseAutoPartitionHandler]收到调度中心执行命令，当前参数：{}", jobParam);
//        JobFactoryParam param = JobParamConverter.parseAndCheckJobParam(jobParam, JobFactoryParam.class);
//        MspTenantVo tenantVo = tenantFacade.getByFactoryCode(param.getFactoryCode());
//        Assert.notNull(tenantVo, MessageFormat.format("[{0}]未查询到租户信息！", param.getFactoryCode()));
//        Assert.notBlack(tenantVo.getId(), "租户ID不能为空！");
//        try {
//            log.info("定时添加数据表分区任务执行开始，参数：{} {}", param.getFactoryCode(), tenantVo.getId());
//            super.setContext(param.getFactoryCode(), tenantVo.getId());
//            long start = System.currentTimeMillis();
//            databaseAutoPartitionHandler.process();
//            log.info("定时添加数据表分区任务执行结束，耗时：{}ms.", System.currentTimeMillis() - start);
//        } finally {
//            super.clearContext();
//        }
//    }
//    秒 分 时
    @Scheduled(cron="0/1 * *  * * ? ")
    public void databaseAutoPartitionTask() {
        log.info(">>>>>>>>[databaseAutoPartitionHandler]开始@Scheduled执行命令");

        try {
            log.info("定时添加数据表分区任务执行开始，参数：{} {}");
            super.setContext("X165", "15435516361346");
            long start = System.currentTimeMillis();
            databaseAutoPartitionHandler.process();
            log.info("定时添加数据表分区任务执行结束，耗时：{}ms.", System.currentTimeMillis() - start);
        } finally {
            super.clearContext();
        }
    }
}
