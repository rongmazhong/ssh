package cn.rong.ssh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ServletComponentScan(basePackages = "cn.rong")
public class SshApplication {
    //private static final Logger log = LoggerFactory.getLogger(SshApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SshApplication.class, args);
	}


}
