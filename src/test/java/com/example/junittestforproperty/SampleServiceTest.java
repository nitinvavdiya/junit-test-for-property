package com.example.junittestforproperty;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;


@RunWith(SpringRunner.class)
public class SampleServiceTest {

	@Autowired
	private SampleService sampleService;
	
	@TestConfiguration
	static class SampleServiceTestConfig {

		@Bean
		public SampleService sampleService() {
			return new SampleService();
		}
	}
	
	@Before
	public void init() {
		ReflectionTestUtils.setField(sampleService, "count", new Integer(100));
		ReflectionTestUtils.setField(sampleService, "countStr", 100);
	}
	
	@Test
	public void testDemoMethod() {
		int a  = sampleService.demoMethod();
		Assert.assertTrue(a == 200);
	}
}
