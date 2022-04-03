package com.nowcoder.community;

import com.nowcoder.community.dao.AlphaDAOmybatisImpl;
import com.nowcoder.community.dao.AlphaDao;
import com.nowcoder.community.dao.test;
import com.nowcoder.community.entity.alphabean1;
import com.nowcoder.community.service.AlphaService;
import com.nowcoder.community.util.MailClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;

import javax.servlet.http.PushBuilder;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
class CommunityApplicationTests implements ApplicationContextAware {
	//ApplicationContextAware这个就是Spring 容器
	//实现这个接口就能看到容器了
	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Autowired
	SimpleDateFormat simpleDateFormat;
//	@Test
//	public void testAppC(){
//		System.out.println(applicationContext);
//		AlphaDao alphaDao = applicationContext.getBean(AlphaDao.class);
//		//获取bean,通过class
//		System.out.println(alphaDao.select());
//		AlphaDao alphaDao2 = applicationContext.getBean("alpha_h",AlphaDao.class);
//		//获取ben,通过名称
//		System.out.println(alphaDao2.select());
//		//这样就.getBean可以获取bean了，人然后就像正常new的一样用
//	}

	@Test
	public void testBeanMA(){
		AlphaService alphaService = applicationContext.getBean(AlphaService.class);
		System.out.println(alphaService);
		AlphaService alphaService2 = applicationContext.getBean(AlphaService.class);
		System.out.println(alphaService2);
	}
	@Test
	public void testBeanC(){
		SimpleDateFormat simpleDateFormat =
				applicationContext.getBean("simpleDateFormat",SimpleDateFormat.class);
		System.out.println(simpleDateFormat.format(new Date()));

	}

	@Autowired
	@Qualifier("alpha_h")
	private AlphaDao alphaDao;

	@Autowired
	private RedisTemplate redisTemplate;
	@Autowired
	private alphabean1 alphabean1;

	@Test
	public void tetbean1(){
		System.out.println(alphabean1.nn);
	}

	@Autowired
	private test test11;
	@Test
	public void testDI(){
		System.out.println(alphaDao);
		System.out.println(test11);
		test11.ss();
	}

	@Autowired
	private MailClient mailClient;

	@Test
	public void test11(){
//		System.out.println(mailClient.from);
	}
}
