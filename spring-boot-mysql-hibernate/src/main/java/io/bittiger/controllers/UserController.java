package io.bittiger.controllers;

import io.bittiger.models.AppDao;
import io.bittiger.models.App_Info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/app")
public class UserController {

  @Autowired
  private AppDao _appDao;

    @RequestMapping("/create")
    @ResponseBody
    public String createApp(String appid, String url) {
        App_Info app_info =_appDao.save(new App_Info(appid,url));
        if (app_info == null){
            System.out.println("Error creating the appid: " + appid);
            return null;
        }
        return "App succesfully created! (appid = " + app_info.getAppid() + ")";
    }

  @RequestMapping(value = "/get-by-appid")
  @ResponseBody
  public String getApp(String appid) {
    System.out.println("Fetching appInfo with appid " + appid);
    App_Info appInfo = _appDao.readApp(appid);
      if (appInfo == null) {
          System.out.println("appInfo with appid " + appid + " not found");
          return null;
      }
    String  appUrl = appInfo.getUrl();
    return appUrl;
  }

}
