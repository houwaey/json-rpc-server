package com.jsonrpc.service;

import java.util.List;

import com.googlecode.jsonrpc4j.JsonRpcError;
import com.googlecode.jsonrpc4j.JsonRpcErrors;
import com.googlecode.jsonrpc4j.JsonRpcService;
import com.jsonrpc.exceptions.InternalServerException;
import com.jsonrpc.exceptions.NoContentException;
import com.jsonrpc.exceptions.UserExistsException;
import com.jsonrpc.exceptions.UserNotFoundException;
import com.jsonrpc.model.WebUser;

@JsonRpcService("/web-user-service")
public interface WebUserService {

	@JsonRpcErrors({
        @JsonRpcError(exception=UserExistsException.class, code=100, message="User already exists"),
        @JsonRpcError(exception=InternalServerException.class, code=99, message="System is busy. Please try again later"),
        @JsonRpcError(exception=Throwable.class, code=1, message="Internal Server Error")
    })
	public WebUser createUser(WebUser user);
	
	@JsonRpcErrors({
        @JsonRpcError(exception=UserNotFoundException.class, code=101, message="User not found"),
        @JsonRpcError(exception=Throwable.class, code=1, message="Internal Server Error")
    })
	public WebUser findUserById(long id);
	
	@JsonRpcErrors({
        @JsonRpcError(exception=UserNotFoundException.class, code=101, message="User not found"),
        @JsonRpcError(exception=Throwable.class, code=1, message="Internal Server Error")
    })
	public WebUser findUserByUsername(String username);
	
	@JsonRpcErrors({
		@JsonRpcError(exception=NoContentException.class, code=102, message="No data found"),
        @JsonRpcError(exception=Throwable.class, code=1, message="Internal Server Error")
	})
	public List<WebUser> findAllUsers();
	
}
