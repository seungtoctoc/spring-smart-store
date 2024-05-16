package smartstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SmartStoreApplication {

  public static void main(String[] args) {
    SpringApplication.run(SmartStoreApplication.class, args);
  }

}
