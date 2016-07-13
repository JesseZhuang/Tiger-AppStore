package io.bit_tiger.webapi.service;

import io.bit_tiger.entity.App_Info;

import java.util.List;

public interface AppService {
	public App_Info createApp(App_Info obj);
	public App_Info readApp(String appId);
	public App_Info updateApp(App_Info obj);
	public App_Info deleteApp(App_Info obj);
	
	public List<App_Info> readAppByUser(String userId);
	public List<App_Info> readAppbyCatalog(String catalogId);
	public List<App_Info> readTopApps(int topN);
	
	public boolean isExist(App_Info appInfo);
	public List<App_Info> readRecomApps(List<String> appIDs);
}
