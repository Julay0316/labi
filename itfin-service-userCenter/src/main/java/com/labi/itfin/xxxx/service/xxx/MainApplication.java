package com.labi.itfin.xxxx.service.xxx;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.concurrent.CountDownLatch;

/**
 * 主函数
 * @author 何智琦
 */
@EnableTransactionManagement
@SpringBootApplication
@EnableCaching
@MapperScan({"com.labi.itfin.xxxx.service.xxx.dao","com.labi.itfin.common.core.dao"})
@ComponentScan({
		"com.labi.itfin.common.core.intercept.sql.monitor.mybatis"
		,"com.labi.itfin.common.core.util"
		,"com.labi.itfin.common.core.dao"
		,"com.labi.itfin.common.core.init"
		,"com.labi.itfin.common.dubbo"
		,"com.labi.itfin.xxxx.service.xxx"
})
public class MainApplication {
	private static final Logger logger = LoggerFactory.getLogger(MainApplication.class);

	@Bean
	public CountDownLatch closeLatch() {
		return new CountDownLatch(1);
	}

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("dubbo.shutdown.hook", "true");
		ApplicationContext ctx = new SpringApplicationBuilder()
				.sources(MainApplication.class)
				// 把项目设置成非web环境
				.web(false)
				.run(args);
		logger.info("项目启动!");
		/*需要注意的是，由于使用了非常纯粹的starter，而且Dubbo的网络框架也是非阻塞的，
		 所以我们还需使用一些方法，保持主线程的阻塞状态。
		 比如我使用CountDownLatch来做这件事。最终形成了以下启动
		 */
		CountDownLatch closeLatch = ctx.getBean(CountDownLatch.class);
		closeLatch.await();
	}
}
