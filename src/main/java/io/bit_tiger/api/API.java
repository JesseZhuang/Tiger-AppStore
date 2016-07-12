package io.bit_tiger.api;

import io.bit_tiger.api.dao.AppDAO;

public class API {

	public AppDAO appDao;
	
	public void setAppDao(AppDAO appDao) {
		this.appDao = appDao;
	}
	
	public AppDAO getAppDao() {
		return appDao;
	}
}
