package cn.rong.ssh.config;

import cn.rong.ssh.config.date.LocalDateFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.time.LocalDate;

/**
 * Author: rong
 * Description:
 * Data: Create in 下午 3:14 17.11.2
 * Package: cn.rong.ssh.config
 */
@Configuration
public class MyMVCConfig extends WebMvcConfigurerAdapter {
	/**
	 * 时间格式化
	 * @param registry
	 */
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatterForFieldType(LocalDate.class,new LocalDateFormatter());
	}
	/**
	 * 错误页的处理
	 */
	/*@Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new ErrorInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }*/

}
