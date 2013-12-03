package com.example.services;

import com.example.framework.CustomService;
import com.example.framework.CustomServiceResponse;
import com.example.framework.Description;
import com.example.framework.requests.GetRequest;
import com.example.framework.requests.PostRequest;

@Description("Operations related to Foo objects in the API")
public class FooService extends CustomService {
	
	@Description("Gets a Foo from the API")
	public class Get extends GetRequest<FooResult> {
		
		@Description("the id of the Foo to Get")
		public int id;

		@Override
		public CustomServiceResponse<FooResult> execute() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	public class Post extends PostRequest<FooPost, FooResult> {

		@Override
		public CustomServiceResponse<FooResult> execute() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

	@Description("A new Foo for posting")
	public class FooPost {
		public String fooResultMember;
	}

	@Description("The result of a Foo operation")
	public class FooResult {
		public int id;
	}
}
