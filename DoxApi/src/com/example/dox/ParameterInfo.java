package com.example.dox;

import java.lang.reflect.Field;

import com.example.MemberInfo;

public class ParameterInfo extends MemberInfo {
	
	public ParameterInfo() {
		
	}
	
	public ParameterInfo(Field field) {
		super(field);
	}

}
