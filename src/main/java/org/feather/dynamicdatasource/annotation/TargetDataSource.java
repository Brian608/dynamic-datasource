package org.feather.dynamicdatasource.annotation;



import org.feather.dynamicdatasource.constants.DataSourceNames;

import java.lang.annotation.*;

/**
 * @projectName: dynamic-datasource
 * @package: org.feather.dynamic.annotation
 * @className: TargetDataSource
 * @author: feather
 * @description:
 * @since: 2023-08-09 10:21
 * @version: 1.0
 */

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TargetDataSource {
    String  value() default DataSourceNames.DS1;
}
