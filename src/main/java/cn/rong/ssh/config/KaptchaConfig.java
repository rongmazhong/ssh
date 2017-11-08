package cn.rong.ssh.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * Author:rong
 * Description:Google的验证码程序配置类
 * Data: Create in 下午 2:55 17.11.7
 * Package: cn.rong.ssh.config
 */
@Component
public class KaptchaConfig {
	@Bean
	public DefaultKaptcha getDefaultKaptcha(){
		DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
		Properties properties = new Properties();
		properties.setProperty("kaptcha.border","yes");
		properties.setProperty("kaptcha.border.color","105,179,90");
		properties.setProperty("kaptcha.textproducer.font.color","blue");
		properties.setProperty("kaptcha.image.width","110");
		properties.setProperty("kaptcha.image.height","40");
		properties.setProperty("kaptcha.textproducer.font.size","30");
		properties.setProperty("kaptcha.session.key","code");
		properties.setProperty("kaptcha.textproducer.char.length","4");
		properties.setProperty("kaptcha.textproducer.font.names","微软雅黑");
		Config config = new Config(properties);
		defaultKaptcha.setConfig(config);
		return defaultKaptcha;
	}
}
