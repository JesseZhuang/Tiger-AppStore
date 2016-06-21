package io.bittiger.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="app_info")
public class App_Info {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @NotNull
  private String appid;

  @NotNull
  private String url;

  public App_Info() { }

    public App_Info(String appid, String url) {
        this.appid = appid;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppid() {
    return appid;
  }

  public void setAppid(String appid) {
    this.appid = appid;
  }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
