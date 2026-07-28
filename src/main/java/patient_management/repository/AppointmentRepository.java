package patient_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import patient_management.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
}
