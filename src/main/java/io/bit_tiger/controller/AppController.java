package io.bit_tiger.controller;


import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.bit_tiger.entity.App_Info;
import io.bit_tiger.webapi.WebApi;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

//import org.codehaus.jackson.JsonGenerationException;
//import org.codehaus.jackson.map.JsonMappingException;
//import org.codehaus.jackson.map.ObjectMapper;

@RestController
public class AppController {
	
	@Resource(name = "webapi") //@Autowired
	private WebApi api;
	
	//-------------------Retrieve Single App--------------------------------------------------------
	@RequestMapping(value = "/app/{appid}", method = RequestMethod.GET)
	public ResponseEntity<App_Info> getApp(@PathVariable("appid") String appid) {
		System.out.println("Fetching appInfo with id " + appid);
		App_Info appInfo = this.api.getAppService().readApp(appid);
		if (appInfo == null) {
			System.out.println("appInfo with id " + appid + " not found");
			return new ResponseEntity<App_Info>(HttpStatus.NOT_FOUND);
		}
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<App_Info>(appInfo,headers, HttpStatus.OK);
	}
	
	//-------------------Retrieve Top 10 Apps--------------------------------------------------------
	@RequestMapping(value = "/app/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<App_Info>> getTopApps() {
		int topN = 10;
//		AppService appService = this.api.getAppService();
//		System.out.println("appservice is null: " + (appService == null));
		List<App_Info> appInfos = this.api.getAppService().readTopApps(topN);
		if (appInfos == null) {
			System.out.println(" no appInfos found");
			return new ResponseEntity<List<App_Info>>(HttpStatus.NOT_FOUND);
		}
		System.out.println("/****************************************************/"+"\r\n"+
		                   "                    Retrievw top 10 Apps              "+"\r\n"+
				           "/****************************************************/");
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<List<App_Info>>(appInfos, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/app/getRecom/similarapp/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<App_Info>> getRecomApps(@RequestBody List<String> appIDs) {
		List<App_Info> appInfos = this.api.getAppService().readRecomApps(appIDs);
		if (appInfos == null|| appInfos.size()==0) {
			System.out.println("AppController 65: no recommandation appInfos found");
			return new ResponseEntity<List<App_Info>>(HttpStatus.NOT_FOUND);
		}
		System.out.println("/****************************************************/"+"\r\n"+
		                   "                    Retrievw 5 Recom Apps              "+"\r\n"+
				           "/****************************************************/");
		System.out.println(appInfos.size()+" "+(appInfos.size()==0?null: appInfos.get(0).getAppid())+" "+appIDs.get(0)+" "+appIDs.size());
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<List<App_Info>>(appInfos, headers, HttpStatus.OK);
	}
	
	//-------------------Create a App--------------------------------------------------------
	
		@RequestMapping(value = "/appInfo/", method = RequestMethod.POST)
		public ResponseEntity<App_Info> createApp(@RequestBody App_Info appInfo, UriComponentsBuilder ucBuilder) {
			System.out.println("Creating App " + appInfo.getTitle());

			if (this.api.getAppService().isExist(appInfo)) {
				System.out.println("A appInfo with name " + appInfo.getTitle() + " already exist");
				return new ResponseEntity<App_Info>(HttpStatus.CONFLICT);
			}

			appInfo = this.api.getAppService().createApp(appInfo);
			
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/appInfo/{appid}").buildAndExpand(appInfo.getAppid()).toUri());
			
			ObjectMapper mapper=new ObjectMapper();
			try {
				String jsonString=mapper.writeValueAsString(appInfo);
				System.out.print(jsonString);
			} catch (JsonGenerationException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return new ResponseEntity<App_Info>(appInfo, headers, HttpStatus.CREATED);
		}

		
		//------------------- Update a App --------------------------------------------------------
		
		@RequestMapping(value = "/appInfo/{appid}", method = RequestMethod.PUT)
		public ResponseEntity<App_Info> updateApp(@PathVariable("appid") String appid, @RequestBody App_Info appInfo) {
			System.out.println("Updating appInfo " + appid);
			
			App_Info currentAppInfo = this.api.getAppService().readApp(appid);
			
			if (currentAppInfo ==null) {
				System.out.println("App with id " + appid + " not found");
				return new ResponseEntity<App_Info>(HttpStatus.NOT_FOUND);
			}else if(appid.equals(appInfo.getAppid()))
				return new ResponseEntity<App_Info>(HttpStatus.CONFLICT);
			
			this.api.getAppService().updateApp(appInfo);
			return new ResponseEntity<App_Info>(currentAppInfo, HttpStatus.OK);
		}

		//------------------- Delete a App --------------------------------------------------------
		
		@RequestMapping(value = "/appInfo/{appid}", method = RequestMethod.DELETE)
		public ResponseEntity<App_Info> deleteApp(@RequestBody App_Info appInfo) {//@RequestBody App appInfo --> 400 bad request, instead please use @PathVariable("appid") String appid
			//App appInfo = new App();
			//appInfo.setAppid(appid);
			System.out.println("\r\n"+ appInfo.getAppid());
			String appid = appInfo.getAppid();
			System.out.println("Fetching & Deleting App with appid " + appInfo.getAppid());
//
			appInfo = this.api.getAppService().deleteApp(appInfo);
			if (appInfo == null) {
				System.out.println("Unable to delete. App with id " + appid + " not found");
				return new ResponseEntity<App_Info>(HttpStatus.NOT_FOUND);
			}

			return new ResponseEntity<App_Info>(HttpStatus.NO_CONTENT);
		}
	 
}
