package com.zuulAPIgateway.Filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PostFilter extends ZuulFilter {
	
	private final static Logger logger = LoggerFactory.getLogger(PostFilter.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request=RequestContext.getCurrentContext().getRequest();
		logger.info("Request-> Request Method-> Request URI-> Request URL-> {} {} {} {}",request,request.getMethod(),request.getRequestURI(),request.getRequestURL());
		return null;
	}

	@Override
	public String filterType() {
		/**
	     * to classify a filter by type. Standard types in Zuul are "pre" for pre-routing filtering,
	     * "route" for routing to an origin, "post" for post-routing filters, "error" for error handling.
	     * We also support a "static" type for static responses see  StaticResponseFilter.
	     * Any filterType made be created or added and run by calling FilterProcessor.runFilters(type)
	     *
	     * @return A String representing that type
	     */
		/*
		 * pre
		 * rout
		 * post
		 */
		return "post";
	}

	@Override
	public int filterOrder() {
		return 1;
	}
}
