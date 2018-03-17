package com.example.junittestforproperty;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@TestPropertySource(properties = {"app.count=100", "app.countStr=100"})
public class SampleServiceTest {

	@Autowired	
	private SampleService sampleService;
	
	@TestConfiguration
	static class SampleServiceTestConfig {

		@Bean
		public SampleService sampleService() {
			 SampleService  sampleService = new SampleService();
		        sampleService.setCount(100);
		        sampleService.setCountStr("100");
		        return sampleService; 
		}
	}
	
	@Before
	public void init() {
	}
	
	@Test
	public void testDemoMethod() {
		int a  = sampleService.demoMethod();
		Assert.assertTrue(a == 200);
	}
}
