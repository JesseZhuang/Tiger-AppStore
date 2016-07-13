package spring_boot_style.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_boot_style.models.App;
import spring_boot_style.models.AppRepo;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/app")
public class AppController {

    @Autowired
    private AppRepo appRepo;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<App> findTop20Apps(){return appRepo.findTop20ByOrderByScoreDesc();};

    // C268 chu bao dianhua
    @RequestMapping(value = "/getRecom/{appid}", method = RequestMethod.GET)
    public List<App> getRecommendedAppsJson(@PathVariable String appid) {
         return appRepo.findAll();
        // return appRepo.findAll().sort(Comparator.comparing());

        // String[] recomList = app.getTop5App();
        // return appRepo.selectTop5AppsByAppid(appid);

    }

    @RequestMapping(value = "/similarapp/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<App>> getRecommendedApps(@RequestBody List<String> appIds) {
        List<App> recomApps = new ArrayList<>(appIds.size());
        for (String appid : appIds) {
            recomApps.add(findApp(appid));
        }
        if (recomApps == null || recomApps.size() == 0) {
            System.out.println("AppController 65: no recommandation appInfos found");
            return new ResponseEntity<List<App>>(HttpStatus.NOT_FOUND);
        }
        System.out.println("/****************************************************/" + "\r\n" +
                "                    Retrievw 5 Recom Apps              " + "\r\n" +
                "/****************************************************/");
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<List<App>>(recomApps, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/{appid}", method = RequestMethod.GET)
    public App findApp(@PathVariable String appid) {
        return appRepo.findOne(appid);
    }

}
