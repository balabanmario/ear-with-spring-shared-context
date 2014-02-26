package springshare;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by Simone Ricciardi on 25/02/14.
 */

@Service
public class SampleServiceImpl implements SampleService {

    @PostConstruct
    private void init(){
        System.out.println("---------------------------------");
        System.out.println("---------------------------------");
        System.out.println("------SampleService created------");
        System.out.println("---------------------------------");
        System.out.println("---------------------------------");

    }

   public String sayHello(String greeting) {
      return "Hello "+greeting+" from " + this.toString();
   }

}
