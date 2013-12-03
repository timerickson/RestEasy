package com.example.dox;

import com.example.framework.Description;

public abstract class ClassEntityInfo {

	public String name;
	public String className;
	public String description;
	
	public ClassEntityInfo() {
		
	}
	
	public ClassEntityInfo(Class<?> entityClass) {
		this();
		initFrom(entityClass);
	}
	
	public void initFrom(Class<?> entityClass) {
		this.className = entityClass.getName();

		String entityName = entityClass.getCanonicalName();
		String[] parts = entityName.split("\\.");
		entityName = parts[parts.length - 1];
		final String Service = "Service";
		if (entityName.endsWith(Service)) {
			entityName = entityName.substring(0, entityName.length() - Service.length());
		}
		if (Character.isUpperCase(entityName.charAt(0))) {
			entityName = Character.toLowerCase(entityName.charAt(0)) + entityName.substring(1);
		}
		this.name = entityName;
		
		Description descriptionAnnotation = entityClass.getAnnotation(Description.class);
		if (descriptionAnnotation != null) {
			this.description = descriptionAnnotation.value();
		}
	}

}
