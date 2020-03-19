package phuhq.it.CONNECT_ORACLE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("phuhq.it")
@EntityScan("phuhq.it")
@EnableJpaRepositories("phuhq.it")
public class ConnectOracleApplication implements CommandLineRunner {

	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(ConnectOracleApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		

	}

}
