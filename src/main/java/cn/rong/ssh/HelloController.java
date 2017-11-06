package cn.rong.ssh;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * Author:rong
 * Description:
 * Data: Create in 上午 11:25 17.11.3
 * Package: cn.rong.ssh
 */
@EnableAutoConfiguration
@RestController
public class HelloController {
	@RequestMapping(value = "/he",method = RequestMethod.GET)
	public ModelAndView hell(){
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("hello","ron");
		modelAndView.addObject("message","rong");
		modelAndView.addObject("time",new Date());

		return modelAndView;
	}
}
