package com.labi.itfin.api.user.center.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * dubbo配置加载
 * @author 何智琦
 */
@Configuration
@PropertySource({ "classpath:dubbo.properties" })
@ImportResource({ "classpath:dubbo/*.xml" })
public class DubboConfig {

}
