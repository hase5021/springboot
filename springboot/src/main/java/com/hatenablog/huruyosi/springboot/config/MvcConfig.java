package com.hatenablog.huruyosi.springboot.config;

import nz.net.ultraq.thymeleaf.LayoutDialect;

import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MvcConfig extends WebMvcAutoConfigurationAdapter {

	/**
	 * thymeleafのテンプレートを利用します。
	 * @return
	 */
	@Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }
}
