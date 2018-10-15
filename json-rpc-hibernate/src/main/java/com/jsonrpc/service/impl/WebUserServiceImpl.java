package com.jsonrpc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import com.jsonrpc.abstracts.AbstractHibernateService;
import com.jsonrpc.dao.UserDao;
import com.jsonrpc.exceptions.InternalServerException;
import com.jsonrpc.exceptions.NoContentException;
import com.jsonrpc.exceptions.UserExistsException;
import com.jsonrpc.exceptions.UserNotFoundException;
import com.jsonrpc.interfaces.Operations;
import com.jsonrpc.model.WebUser;
import com.jsonrpc.service.WebUserService;

@AutoJsonRpcServiceImpl
@Service
public class WebUserServiceImpl extends AbstractHibernateService<WebUser> implements WebUserService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserDao<WebUser> dao;
	
	@Override
	protected Operations<WebUser> getDao() {
		return dao;
	}
	
	public WebUserServiceImpl() {
		super();
	}
	
	@Override
	public WebUser createUser(WebUser user) {
		WebUser tempUser = findOneByKeyVal("username", user.getUsername());
		if (tempUser != null) {
			throw new UserExistsException();
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		boolean created = create(user);
		if (!created) {
			throw new InternalServerException();
		}
		return user;
	}

	@Override
	public WebUser findUserById(long id) {
		WebUser user = findOneById(id);
		if (user == null) {
			throw new UserNotFoundException();
		}
		return user;
	}

	@Override
	public WebUser findUserByUsername(String username) {
		WebUser user = findOneByKeyVal("username", username);
		if (user == null) {
			throw new UserNotFoundException();
		}
		return user;
	}
	
	@Override
	public List<WebUser> findAllUsers() {
		List<WebUser> users = findAll();
		if (users.size() <= 0) {
			throw new NoContentException();
		}
		return users;
	}

}
