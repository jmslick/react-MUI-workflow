package main.java.com.gdeb.ripout.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import main.java.com.gdeb.ripout.model.Ripout;
import main.java.com.gdeb.ripout.routing.Routing;

@Configuration
//@Slf4j
//@Log
class LoadDatabase {
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(RipoutRepository repository) {

		return args -> {
			log.info("Preloading " + repository
					.save(new Ripout(1, Routing.ROUTING_RIPOUT_WRITER, true, Routing.STATUS_DRFT, 012345, "siczpak")));
			log.info("Preloading " + repository
					.save(new Ripout(1, Routing.ROUTING_RIPOUT_WRITER, true, Routing.STATUS_DRFT, 678901, "kincaid")));
		};
	}
}