package spring_boot_style.models;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppRepo extends JpaRepository<App, String> {

    // List<App> selectTop5AppsByAppid(String appid);

    List<App> findTop20ByOrderByScoreDesc();
}
