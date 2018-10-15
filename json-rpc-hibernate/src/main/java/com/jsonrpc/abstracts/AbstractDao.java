package com.jsonrpc.abstracts;

import java.io.Serializable;

import com.google.common.base.Preconditions;
import com.jsonrpc.interfaces.Operations;

public abstract class AbstractDao<T extends Serializable> implements Operations<T> {

	protected Class<T> clazz;
	
	protected final void setClazz(final Class<T> clazzToSet) {
		clazz = Preconditions.checkNotNull(clazzToSet);
	}
	
}