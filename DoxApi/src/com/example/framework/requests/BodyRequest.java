package com.example.framework.requests;

import com.example.framework.CustomServiceRequest;

public abstract class BodyRequest<TBody, TResult> extends CustomServiceRequest<TResult> {
	public TBody body;
}
