package patient_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import patient_management.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
