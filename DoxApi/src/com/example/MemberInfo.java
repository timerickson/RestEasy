package com.example;

import java.lang.reflect.Field;

import com.example.framework.Description;

public class MemberInfo {
	public String name;
	public String description;
	public boolean optional;
	
	public MemberInfo() {
		
	}
	
	public MemberInfo(Field field) {
		this.name = field.getName();
		Description desc = field.getAnnotation(Description.class);
		if (desc != null) {
			this.description = desc.value();
			this.optional = desc.optional();
		}
	}
}
