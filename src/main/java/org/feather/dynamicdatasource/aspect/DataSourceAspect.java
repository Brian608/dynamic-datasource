package org.feather.dynamicdatasource.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.feather.dynamicdatasource.annotation.TargetDataSource;
import org.feather.dynamicdatasource.config.DynamicDataSource;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @projectName: dynamic-datasource
 * @package: org.feather.dynamic.aspect
 * @className: DataSourceAspect
 * @author: feather
 * @description:
 * @since: 2023-08-09 10:22
 * @version: 1.0
 */

@Aspect
@Component
@Slf4j
public class DataSourceAspect   {
    @Pointcut("@annotation(org.feather.dynamicdatasource.annotation.TargetDataSource)")
    public void dataSourcePointCut() {

    }

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point)  {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        TargetDataSource ds = method.getAnnotation(TargetDataSource.class);
        // 通过判断 DataSource 中的值来判断当前方法应用哪个数据源
        DynamicDataSource.setDataSource(ds.value());
        log.info("AOP切换数据源成功，数据源为: " + ds.value());
        log.info("set datasource is " + ds.value());
        try {
            return point.proceed();
        } catch (Throwable e) {
            DynamicDataSource.clearDataSource();
            log.info("clean datasource");
        }
        return null;
    }



}
