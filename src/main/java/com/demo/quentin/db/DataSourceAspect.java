package com.demo.quentin.db;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @Auth Created by guoqun.yang
 * @Date Created in 11:18 2017/12/19
 * @Version 1.0
 */
public class DataSourceAspect {

    private static Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);

    public void beforeAdvice(JoinPoint jp) {
        try {
            MethodSignature methodSignature = (MethodSignature) jp.getSignature();
            Class targetClass = jp.getTarget().getClass();
            // 默认使用目标类型的注解，如果没有则使用其实现接口的注解
            for (Class<?> clazz : targetClass.getInterfaces()) {
                resolveDataSource(clazz,methodSignature.getMethod());
            }
            resolveDataSource(targetClass,methodSignature.getMethod());
        } catch (Exception e) {
            logger.error("数据源切换发生异常：",e);
        }
    }

    public void resolveDataSource(Class<?> clazz,Method method){
        try {
            //类注解
            Class<?>[] types = method.getParameterTypes();
            if (clazz.isAnnotationPresent(DataSource.class)){
                DataSource ds = clazz.getAnnotation(DataSource.class);
                DataSourceHolder.setDS(ds.name());
            }
            //方法注解
            Method m = clazz.getMethod(method.getName(),types);
            if (m.isAnnotationPresent(DataSource.class)) {
                DataSource ds = method.getAnnotation(DataSource.class);
                DataSourceHolder.setDS(ds.name());
            }
        } catch (NoSuchMethodException e) {
            logger.error("DataSourceAspect.resolveDataSource获取目标对象数据源标识发生异常：",e);
        }
    }

}
