package com.jsonrpc.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;

@AutoJsonRpcServiceImpl
@Service
public class UserServiceImpl implements UserService {

	private Map<String, User> users = new HashMap<String, User>();
	
	@Override
	public User createUser(String username, String password) {
		User user = new User(username, password);
		users.put(username, user);
		return user;
	}

	@Override
	public User findUserByUsername(String username) {
		if (users.containsKey(username)) {
			return users.get(username);
		}
		return null;
	}

}
