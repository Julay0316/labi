package com.labi.itfin.api.user.center;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 主函数
 * @author 何智琦
 */
@SpringBootApplication(exclude = {
		DataSourceAutoConfiguration.class
		, DataSourceTransactionManagerAutoConfiguration.class
		, HibernateJpaAutoConfiguration.class
})
@ComponentScan({
		"com.labi.itfin.common.core.util"
		,"com.labi.itfin.common.core.init"
		,"com.labi.itfin.common.dubbo"
		,"com.labi.itfin.api.user.center"
})
@Slf4j
public class MainApplication {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("dubbo.shutdown.hook", "true");
		ApplicationContext ctx = new SpringApplicationBuilder()
				.sources(MainApplication.class)
				.run(args);
		log.info("项目启动!");
	}
}
