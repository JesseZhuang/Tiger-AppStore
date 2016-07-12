package io.bit_tiger.api.dao;

import io.bit_tiger.entity.App_Info;

import java.util.List;

public interface AppDAO {
	public App_Info createApp(App_Info appInfoObj);
	public App_Info deleteApp(App_Info appInfoObj);
	public App_Info updateApp(App_Info appInfoObj);
	public App_Info readApp(String appID);
	
	public List<App_Info> readAppByCatalog(String catalogID);
	public List<App_Info> readAppByUser(String userID);
	public List<App_Info> readTopApps(int topN);
	
	public boolean isAppExist(App_Info appInfo);
	public List<App_Info> readRecomApps(List<String> appIDs);
}
