package com.example;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.example.dox.ServiceInfo;
import com.example.services.FooService;

public class ServiceInfoTest {

	final public static String PackageName = "com.example";
	
	@Test
	public void collectShouldReturnTwoServiceInfos() {
		List<ServiceInfo> serviceInfos = ServiceInfo.Collect(PackageName);
		assertEquals(2, serviceInfos.size());
	}
	
	@Test
	public void nameShouldBeServiceClassNameWithLowerFirstLetterWithoutTrailingService() {
		ServiceInfo serviceInfo = new ServiceInfo(FooService.class);
		assertEquals("foo", serviceInfo.name);
	}
	
	@Test
	public void classNameShouldBeServiceClassName() {
		ServiceInfo serviceInfo = new ServiceInfo(FooService.class);
		assertEquals("com.example.FooService", serviceInfo.className);
	}
	
	@Test
	public void descriptionShouldBeDescriptionAnnotationValue() {
		ServiceInfo serviceInfo = new ServiceInfo(FooService.class);
		assertEquals("Operations related to Foo objects in the API", serviceInfo.description);
	}
	
	@Test
	public void fooServiceInfoShouldHaveTwoOperationInfos() {
		ServiceInfo serviceInfo = new ServiceInfo(FooService.class);
		assertEquals(2, serviceInfo.operations.length);
	}

}
