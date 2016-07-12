package io.bit_tiger.api.dao.impl;

import io.bit_tiger.api.dao.AppDAO;
import io.bit_tiger.entity.App_Info;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class AppImpl implements AppDAO{
	private SessionFactory sessionFactory;
	
	@Override
	/*
	 * Problem: App's coms and cata are both fetchType.EAGER, but when read, they are loaded.
	 * @see com.appstore.api.dao.AppDAO#createApp(com.appstore.entity.App)
	 */
	public App_Info createApp(App_Info appInfoObj) {
		// TODO Auto-generated method stub
		Object obj = this.getSession().save(appInfoObj);
		appInfoObj = this.readApp(obj.toString());
		return appInfoObj;
	}

	@Override
	public App_Info deleteApp(App_Info appInfoObj) {
		// TODO Auto-generated method stub
		this.getSession().delete(appInfoObj);
		return appInfoObj;
	}

	@Override
	public App_Info updateApp(App_Info appInfoObj) {
		// TODO Auto-generated method stub
		this.getSession().update(appInfoObj);
		return null;
	}

	@Override
	public App_Info readApp(String appID) {
		// TODO Auto-generated method stub
		App_Info appInfo = (App_Info) this.getSession().get(App_Info.class, appID);
		return appInfo;
	}

	@Override
	public List<App_Info> readAppByCatalog(String catalogID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<App_Info> readAppByUser(String userID) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean isAppExist(App_Info appInfo) {
		// TODO Auto-generated method stub
		String appid = appInfo.getAppid();
		Query query = this.getSession().createQuery("select count(*) from App_Info appInfo where appInfo.appid = :appid").setString("appid", appid);
		long count = (long) query.uniqueResult();
		return count == 1 ? true : false;
	}

	@Override
	public List<App_Info> readTopApps(int topN) {
		// TODO Auto-generated method stub
		Query query = this.getSession().createQuery("from App_Info appInfo order by appInfo.score desc").setMaxResults(topN);
		List<App_Info> appInfos = (List<App_Info>)query.list();
		return appInfos;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

    public Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

	@Override
	public List<App_Info> readRecomApps(List<String> appIDs) {
		// TODO Auto-generated method stub
		if(appIDs == null)
			return new ArrayList<>();
		
		List<App_Info> recomAppInfos = new ArrayList<>(appIDs.size());
		for(String appid : appIDs){
			App_Info appInfo = this.readApp(appid);
			if(appInfo != null)
				recomAppInfos.add(appInfo);
			else{
				System.out.println("appImpl 104 returned appInfo with id: "+appid+" is null");
			}
		}
		return recomAppInfos;
	}
}
