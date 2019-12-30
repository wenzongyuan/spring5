package com.wzy.spring.mytest.beanfactoryTest.beanFactoryTest1;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * BeanFactory 测试类
 */
public class BeanFactoryTest {

	@Test
	public void beanFactoryTest() throws IOException {

		//PathMatchingResourcePatternResolver 是spring提供的标准的资源解析器（就是用通过路径匹配加载资源，
		// 在AbstractApplication 中也是默认使用PathMatchingResourcePatternResolver 资源解析器）
		ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		Resource[] resources = resourcePatternResolver.getResources("classpath:com/beanFactoryTest/beanFactoryTest1.xml");

		System.out.println(resources[0].getURL());
		System.out.println(resources[0].getURI());

		//最常用的XmlBeanFactory 已经被废弃掉，官方建议使用DefaultListableBeanFactory + XmlBeanDefinitionReader来构建容器
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		//通过资源加载BeanDefinition
		reader.loadBeanDefinitions(resources);

		Car car = factory.getBean(Car.class);

		System.out.println(car.getBrand());


	}
}
