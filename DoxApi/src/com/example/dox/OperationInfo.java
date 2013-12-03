package com.example.dox;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import com.example.framework.requests.BodyRequest;

public class OperationInfo extends ClassEntityInfo {
	
	public BodyInfo body;
	
	public ResultInfo result;
	
	public ParameterInfo[] parameters;
	
	public OperationInfo() {
		
	}
	
	public OperationInfo(Class<?> entityClass) {
		super(entityClass);
	}

	@Override
	public void initFrom(Class<?> requestClass) {
		super.initFrom(requestClass);
		
		ParameterizedType pType = (ParameterizedType)requestClass.getGenericSuperclass();

		boolean canHaveBody = false;
		if (BodyRequest.class.isAssignableFrom(requestClass)) {
			canHaveBody = true;
			Class<?> bodyType = (Class<?>)pType.getActualTypeArguments()[0];
			body = new BodyInfo(bodyType);
		}
		
		int resultTypeIndex = canHaveBody ? 1 : 0;
		Class<?> resultType = (Class<?>)pType.getActualTypeArguments()[resultTypeIndex];
		result = new ResultInfo(resultType);
		
		List<ParameterInfo> parms = new ArrayList<ParameterInfo>();
		Field[] fields = requestClass.getFields();
		for (Field field : fields) {
			if (canHaveBody && field.getName().equals("body")) {
				continue;
			}
			ParameterInfo parmInfo = new ParameterInfo(field);
			parms.add(parmInfo);
		}
		parameters = parms.toArray(new ParameterInfo[0]);
	}
	
}
