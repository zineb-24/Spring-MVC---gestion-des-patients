package ma.mundiapolis.patientmvc;

import ma.mundiapolis.patientmvc.entities.Patient;
import ma.mundiapolis.patientmvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientMvcApplication.class, args);
	}

	//@Bean
	CommandLineRunner commandLineRunner(PatientRepository patientRepository) {
		return args -> {
			patientRepository.save(new Patient(null, "Joe Goldberg", new Date(), false, 112));
			patientRepository.save(new Patient(null, "Love Quinn", new Date(), true, 218));
			patientRepository.save(new Patient(null, "Anne Shirley", new Date(), true, 225));
			patientRepository.save(new Patient(null, "Gilbert Blythe", new Date(), false, 332));

			patientRepository.findAll().forEach(p -> {
				System.out.println(p.getNom());
			});
		};
	}

}
