package patient_management.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import patient_management.entity.Appointment;
import patient_management.entity.Patient;
import patient_management.entity.Doctor;
import patient_management.repository.AppointmentRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AppointmentServiceTest {

    @Mock
    private AppointmentRepository appointmentRepository;

    @InjectMocks
    private AppointmentService appointmentService;

    @Test
    public void testSaveAppointment(){
        Patient patient = new Patient();
        patient.setId(1L);
        patient.setName("Test Patient");

        Doctor doctor = new Doctor();
        doctor.setId(1L);
        doctor.setName("Test Doctor");

        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setAppointmentDate(LocalDateTime.parse("2026-07-28T14:30:00"));
        appointment.setReason("Fever");
        appointment.setStatus("SCHEDULED");

        when(appointmentRepository.save(appointment)).thenReturn(appointment);

        Appointment result = appointmentService.saveAppointment(appointment);

        assertEquals("Test Patient", result.getPatient().getName());
        assertEquals("Test Doctor", result.getDoctor().getName());
        assertEquals("SCHEDULED", result.getStatus());
    }

    @Test
    public void testGetAllAppointments(){
        Appointment a1 = new Appointment();
        a1.setReason("Fever");

        Appointment a2 = new Appointment();
        a2.setReason("Cold");

        when(appointmentRepository.findAll()).thenReturn(List.of(a1, a2));

        List<Appointment> result = appointmentService.getAllAppointments();

        assertEquals(2, result.size());
    }

    @Test
    public void testGetAppointmentById(){
        Appointment appointment = new Appointment();
        appointment.setId(1L);
        appointment.setReason("Checkup");

        when(appointmentRepository.findById(1L)).thenReturn(Optional.of(appointment));

        Appointment result = appointmentService.getAppointmentById(1L);

        assertEquals("Checkup", result.getReason());
    }

    @Test
    public void testDeleteAppointment(){
        appointmentService.deleteAppointment(1L);
        verify(appointmentRepository, times(1)).deleteById(1L);
    }
}