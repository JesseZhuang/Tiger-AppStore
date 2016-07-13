package io.bit_tiger.webapi.service.impl;

import io.bit_tiger.api.API;
import io.bit_tiger.entity.App_Info;
import io.bit_tiger.webapi.service.AppService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class AppServiceImpl implements AppService{

	private API api;
	
	@Override
	@Transactional
	public App_Info createApp(App_Info obj) {
		// TODO Auto-generated method stub
		return this.api.getAppDao().createApp(obj);
	}

	@Override
	@Transactional
	public App_Info readApp(String appId) {
		// TODO Auto-generated method stub
		return this.api.getAppDao().readApp(appId);
	}

	@Override
	@Transactional
	public App_Info updateApp(App_Info obj) {
		// TODO Auto-generated method stub
		return this.api.getAppDao().updateApp(obj);
	}

	@Override
	@Transactional
	public App_Info deleteApp(App_Info obj) {
		// TODO Auto-generated method stub
		return this.api.getAppDao().deleteApp(obj);
	}

	@Override
	@Transactional
	public List<App_Info> readAppByUser(String userId) {
		// TODO Auto-generated method stub
		return this.api.getAppDao().readAppByUser(userId);
	}

	@Override
	@Transactional
	public List<App_Info> readAppbyCatalog(String catalogId) {
		// TODO Auto-generated method stub
		return this.api.getAppDao().readAppByCatalog(catalogId);
	}

	@Override
	@Transactional
	public List<App_Info> readTopApps(int topN) {
		// TODO Auto-generated method stub
		return this.api.getAppDao().readTopApps(topN);
	}
	
	public API getApi() {
		return api;
	}

	public void setApi(API api) {
		this.api = api;
	}

	@Override
	@Transactional
	public boolean isExist(App_Info appInfo) {
		// TODO Auto-generated method stub
		return this.api.getAppDao().isAppExist(appInfo);
		
	}

	@Override
	@Transactional
	public List<App_Info> readRecomApps(List<String> appIDs) {
		// TODO Auto-generated method stub
		return this.api.getAppDao().readRecomApps(appIDs);
	}

}
