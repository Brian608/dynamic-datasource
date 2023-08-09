package org.feather.dynamicdatasource.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import lombok.extern.slf4j.Slf4j;
import org.feather.dynamicdatasource.constants.DataSourceNames;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @projectName: dynamic-datasource
 * @package: org.feather.dynamic.config
 * @className: DynamicDataSourceConfig
 * @author: feather
 * @description:
 * @since: 2023-08-09 10:23
 * @version: 1.0
 */

@Slf4j
@Configuration
public class DynamicDataSourceConfig {
    /**
     * 创建 DataSource Bean
     * */

    @Bean
    @ConfigurationProperties("spring.datasource.ds1")
    public DataSource ds1DataSource(){
        DataSource dataSource = DruidDataSourceBuilder.create().build();
        return dataSource;
    }

    @Bean
    @ConfigurationProperties("spring.datasource.ds2")
    public DataSource ds2DataSource(){
        DataSource dataSource = DruidDataSourceBuilder.create().build();
        return dataSource;
    }

    /**
     * 将数据源信息载入targetDataSources
     * */

    @Bean
    @Primary
    public DynamicDataSource dataSource(DataSource ds1DataSource, DataSource ds2DataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>(2);
        targetDataSources.put(DataSourceNames.DS1, ds1DataSource);
        targetDataSources.put(DataSourceNames.DS2, ds2DataSource);
        // 如果还有其他数据源,可以按照数据源ds1和ds2这种方法去进行配置，然后在targetDataSources中继续添加
        log.info("加载的数据源DataSources:" + targetDataSources);

        //DynamicDataSource（默认数据源,所有数据源） 第一个指定默认数据库
        return new DynamicDataSource(ds1DataSource, targetDataSources);
    }
}

