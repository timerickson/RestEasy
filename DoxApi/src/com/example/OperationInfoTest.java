package com.example;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.dox.OperationInfo;
import com.example.dox.ParameterInfo;
import com.example.services.FooService;

public class OperationInfoTest {

	@Test
	public void fooGetShouldHaveIdFieldInfo() {
		OperationInfo info = new OperationInfo(FooService.Get.class);
		assertEquals(1, info.parameters.length);
		ParameterInfo parameter = info.parameters[0];
		assertEquals("id", parameter.name);
		assertEquals("the id of the Foo to Get", parameter.description);
		assertEquals(false, parameter.optional);
	}
	
	@Test
	public void fooGetShouldHaveFooResultResultInfo() {
		OperationInfo info = new OperationInfo(FooService.Get.class);
		assertNotNull(info.result);
		assertEquals("fooResult", info.result.name);
		assertEquals("com.example.FooService$FooResult", info.result.className);
		assertEquals("The result of a Foo operation", info.result.description);
	}
	
	@Test
	public void fooPostShouldHaveNoParameters() {
		OperationInfo info = new OperationInfo(FooService.Post.class);
		assertEquals(0, info.parameters.length);
	}
	
	@Test
	public void fooPostShouldHaveFooPostBodyInfo() {
		OperationInfo info = new OperationInfo(FooService.Post.class);
		assertNotNull(info.body);
		assertEquals("fooPost", info.body.name);
		assertEquals("com.example.FooService$FooPost", info.body.className);
		assertEquals("A new Foo for posting", info.body.description);
	}
	
	@Test
	public void fooPostShouldHaveFooResultResultInfo() {
		OperationInfo info = new OperationInfo(FooService.Post.class);
		assertNotNull(info.result);
		assertEquals("fooResult", info.result.name);
		assertEquals("com.example.FooService$FooResult", info.result.className);
		assertEquals("The result of a Foo operation", info.result.description);
	}

}
