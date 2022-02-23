import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpringStart {
    public static void main(String[] args) {
        try {
            SpringApplication.run(SpringStart.class, args);
            System.out.println("Запущено успешно");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    }

