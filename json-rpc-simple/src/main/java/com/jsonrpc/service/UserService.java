package com.jsonrpc.service;

import com.googlecode.jsonrpc4j.JsonRpcParam;
import com.googlecode.jsonrpc4j.JsonRpcService;

@JsonRpcService("/user-service")
public interface UserService {

	public User createUser(@JsonRpcParam(value = "theUsername") String username, @JsonRpcParam(value = "thePassword") String password);
	
	public User findUserByUsername(@JsonRpcParam(value = "theUsername") String username);
	
}
