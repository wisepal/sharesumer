package sharesumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableConfigServer
@EnableSpringDataWebSupport
public class SharesumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SharesumerApplication.class, args);
    }


}
