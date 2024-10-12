package org.lyflexi.basicdebug.task;

/**
 * @Description:
 * @Author: lyflexi
 * @project: mybatis-plus-practice
 * @Date: 2024/10/12 10:04
 */

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.lyflexi.basicdebug.dao.PostgreSqlPartitionMapper;
import org.lyflexi.basicdebug.entity.bo.PartitionConfigBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class DatabaseAutoPartitionJobHandler {
    @Autowired
    private PostgreSqlPartitionMapper postgreSqlPartitionMapper;
//    @Autowired
//    private CacheSettingFacade settingFacade;

    private static final String DATABASE_AUTO_PARTITION_CONFIG = "database_auto_partition_config";

    public void process() {
//        MspSettingVo mspSettingVo = settingFacade.getSetting(DATABASE_AUTO_PARTITION_CONFIG);
//        if (mspSettingVo == null || mspSettingVo.getConfigValue() == null) {
//            log.error("获取数据库自动分区配饰失败，配置键值：{}, 配置: {}", DATABASE_AUTO_PARTITION_CONFIG, mspSettingVo);
//            return;
//        }
//        List<PartitionConfigBo> tableSettingList = JSON.parseArray(mspSettingVo.getConfigValue(), PartitionConfigBo.class);
        List<PartitionConfigBo> tableSettingList = JSON.parseArray("[{\"tableName\":\"t_les_receipting\",\"periodUnit\":\"month\",\"period\":1}]\n", PartitionConfigBo.class);
        for (PartitionConfigBo config : tableSettingList) {
            if (config.getTableName() == null || config.getPeriodUnit() == null
                    || config.getPeriod() == null) {
                log.error("跳过异常配置：{}", config);
                continue;
            }
            // 创建分区表
            createCurrentAndNextPeriodPartition(config);
        }
    }

    /**
     * 为指定表创建当前月和下一个月的分区表，若已存在则无操作
     *
     * @param config
     */
    private void createCurrentAndNextPeriodPartition(PartitionConfigBo config) {
        try {
            log.info("生成分区表准备完毕：{}", config);
            // 后续会增加配置支持，此处演示自动分区功能先按1个月的跨度进行分区
            postgreSqlPartitionMapper.createCurrentAndNextPeriodPartition(config.getTableName(),
                    config.getPeriodUnit(), config.getPeriod());
            log.info("生成分区表完成：{}", config);
        } catch (Exception e) {
            log.error("生成分区表错误：{}", config, e);
        }
    }
}




