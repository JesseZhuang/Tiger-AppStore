package io.bit_tiger.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "app_info")
public class App_Info {
	private String title;
	private String appid;
	private String thumbnail_url;
	private String intro;
	private String url;
	private String developer;
	private String top5App;
	private int score = 0; 
	
	private String[] top5AppsArr;
	@Transient
	public String[] getTop5AppsArray() {
		
		if(this.top5App != null && this.top5App.length() > 0){
			this.top5App = this.top5App.substring(1, this.top5App.length()-1);
			
			String[] appIDs = this.top5App.split(",");
			this.top5AppsArr = new String[5];
			
			for(int i = 0 ; i < appIDs.length; i++)
				this.top5AppsArr[i] = appIDs[i].trim();
		}else
			return new String[]{};
	
		return top5AppsArr;
	}

	@Id
	public String getAppid() {
		return appid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumbnail_url() {
		return thumbnail_url;
	}

	public void setThumbnail_url(String thumbnail_url) {
		this.thumbnail_url = thumbnail_url;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public String getTop5App() {
		return top5App;
	}

	public void setTop5App(String top5App) {
		this.top5App = top5App;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}
	
}
