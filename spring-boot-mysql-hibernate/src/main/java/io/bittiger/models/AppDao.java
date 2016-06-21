package io.bittiger.models;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class AppDao {
  
  @Autowired
  private SessionFactory _sessionFactory;
  
  private Session getSession() {
    return _sessionFactory.getCurrentSession();
  }

  public App_Info save(App_Info app_info) {
    getSession().save(app_info);
    return app_info;
  }

  public App_Info readApp(String appid) {
    App_Info app_info = (App_Info) this.getSession().createQuery("from App_Info app where app.appid = :appid").setString("appid", appid).uniqueResult();
    return app_info;
  }

}
