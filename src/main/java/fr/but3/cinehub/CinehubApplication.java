package fr.but3.cinehub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main class for the Cinehub application.
 * This class is responsible for starting the application.
 */
@SpringBootApplication
public class CinehubApplication {

	/**
	 * The main method that starts the Cinehub application.
	 * @param args The command line arguments.
	 */
	public static void main(String[] args) {
		SpringApplication.run(CinehubApplication.class, args);
	}

}
