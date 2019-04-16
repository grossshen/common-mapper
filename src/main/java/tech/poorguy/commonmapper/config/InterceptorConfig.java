package tech.poorguy.commonmapper.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import tech.poorguy.commonmapper.interceptor.AllowCrossDomainInterceptor;
import tech.poorguy.commonmapper.interceptor.ResponseResultInterceptor;

/**
 * @author poorguy
 * @version 0.0.1
 * @E-mail 494939649@qq.com
 * @created 2019/4/16 11:36
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {


    /**
     * @Description:配置返回拦截
     */
    @Autowired
    private ResponseResultInterceptor responseResultInterceptor;

    /**
     * @Description:配置跨域拦截
     */
    @Autowired
    private AllowCrossDomainInterceptor allowCrossDomainInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String apiUri = "/api/**";
        //响应结果控制拦截
        registry.addInterceptor(responseResultInterceptor).addPathPatterns(apiUri);

        String apiUriCrossDomain="/"+"api"+"/**";
        registry.addInterceptor(allowCrossDomainInterceptor).addPathPatterns(apiUriCrossDomain);
    }



}

