package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.apache.commons.collections.Bag;
import org.apache.commons.collections.bag.HashBag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Application {
	@Bean
	public MyBean myBean(){
		return new MyBean();
	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);

		MyBean bean = context.getBean(MyBean.class);
		bean.doSomething();
	}

	private static class MyBean{
		public void doSomething(){
			Bag bag = new HashBag();
			bag.add("ONE", 6);
			System.out.println("Doing something in MyBean");
			System.out.println(bag);
		}
	}

	@RestController
	private static class TheController{
		@RequestMapping("/rest")
		public String handle(){
			return "message from rest handler";
		}
	}
}
