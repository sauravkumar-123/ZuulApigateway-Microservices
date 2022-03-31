package com.zuulAPIgateway;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.zuulAPIgateway.Filter.ErrorFilter;
import com.zuulAPIgateway.Filter.PostFilter;
import com.zuulAPIgateway.Filter.PreFilter;
import com.zuulAPIgateway.Filter.RouteFilter;

import brave.sampler.Sampler;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class ZuulApIgatewayApplication {

	@Value("${server.port}")
	private String portno;

	private final static Logger logger = LoggerFactory.getLogger(ZuulApIgatewayApplication.class);

	public static void main(String[] args) {
		logger.info("<--------------ZuulAPIgateway Server Start-------------->");
		SpringApplication.run(ZuulApIgatewayApplication.class, args);
		logger.info("<--------------ZuulAPIgateway Server End-------------->");
	}

	@PostConstruct
	public void init() {
		logger.info("<---------ZuulAPIgateway Run On PortNo:------------>" + portno);
	}

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

//	@Bean
//	public PreFilter preFilter() {
//		return new PreFilter();
//	}
//
//	@Bean
//	public PostFilter postFilter() {
//		return new PostFilter();
//	}
//
//	@Bean
//	public ErrorFilter errorFilter() {
//		return new ErrorFilter();
//	}
//
//	@Bean
//	public RouteFilter routeFilter() {
//		return new RouteFilter();
//	}
}
