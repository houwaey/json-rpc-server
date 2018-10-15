package com.jsonrpc.dao;

import java.io.Serializable;

import com.jsonrpc.interfaces.Operations;

public interface UserDao<T extends Serializable> extends Operations<T> {

}