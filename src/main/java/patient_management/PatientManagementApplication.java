package patient_management;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import patient_management.entity.User;
import patient_management.repository.UserRepository;

@SpringBootApplication
public class PatientManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientManagementApplication.class, args);
    }

    @Bean
    public CommandLineRunner seedUsers(UserRepository userRepository) {
        return args -> {
            if (userRepository.findByUsername("admin") == null) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword("admin123");
                admin.setRole("ADMIN");
                userRepository.save(admin);
            }

            if (userRepository.findByUsername("doctor1") == null) {
                User doctor = new User();
                doctor.setUsername("doctor1");
                doctor.setPassword("doctor123");
                doctor.setRole("DOCTOR");
                userRepository.save(doctor);
            }
        };
    }
}