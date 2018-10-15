package com.jsonrpc.dao.impl;

import org.springframework.stereotype.Repository;

import com.jsonrpc.abstracts.AbstractHibernateDao;
import com.jsonrpc.dao.UserDao;
import com.jsonrpc.model.WebUser;

@Repository
public class WebUserDao extends AbstractHibernateDao<WebUser> implements UserDao<WebUser>{

	public WebUserDao() {
		super();
		setClazz(WebUser.class);
	}
	
	
}