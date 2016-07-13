package io.bit_tiger.webapi;

import io.bit_tiger.webapi.service.AppService;

//@Configuration
public class WebApi {

	//@Autowired
	private AppService appService;

	//@Bean
	public AppService getAppService() {
		return appService;
	}
	public void setAppService(AppService appService) {
		this.appService = appService;
	}
}
