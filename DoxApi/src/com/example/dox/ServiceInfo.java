package com.example.dox;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;

import com.example.framework.CustomService;
import com.example.framework.CustomServiceRequest;

public class ServiceInfo extends ClassEntityInfo {
	
	public OperationInfo[] operations;
	
	public ServiceInfo(Class<? extends CustomService> serviceType) {
		super(serviceType);
	}

	@Override
	public void initFrom(Class<?> entityClass) {
		super.initFrom(entityClass);
		List<OperationInfo> operationInfos = new ArrayList<OperationInfo>();
		List<EntityInfo> entityInfos = new ArrayList<EntityInfo>();
		Class<?>[] relatedClasses = entityClass.getClasses();
		for (Class<?> clazz : relatedClasses) {
			if (isOperation(clazz)) {
				operationInfos.add(new OperationInfo(clazz));
			} else {
				entityInfos.add(new EntityInfo(clazz));
			}
		}
		operations = operationInfos.toArray(new OperationInfo[0]);
	}

	public static boolean isOperation(Class<?> clazz) {
		return CustomServiceRequest.class.isAssignableFrom(clazz);
	}

	public static List<ServiceInfo> Collect(String packageName) {
		List<ServiceInfo> serviceInfos = new ArrayList<ServiceInfo>();
		Reflections reflections = new Reflections(packageName);
		
		Set<Class<? extends CustomService>> serviceTypes = 
				reflections.getSubTypesOf(CustomService.class);
		
		//	     Set<Class<?>> annotated = 
		//	               reflections.getTypesAnnotatedWith(SomeAnnotation.class);
		 
		 for (Class<? extends CustomService> serviceType : serviceTypes) {
			 ServiceInfo serviceInfo = new ServiceInfo(serviceType);
			 serviceInfos.add(serviceInfo);
		 }
		 
		 return serviceInfos;
	}
}
