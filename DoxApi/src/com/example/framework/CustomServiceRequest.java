package com.example.framework;

public abstract class CustomServiceRequest<TResult> {
	public abstract CustomServiceResponse<TResult> execute();
}
