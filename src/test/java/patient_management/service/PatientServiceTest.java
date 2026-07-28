package patient_management.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import patient_management.entity.Patient;
import patient_management.repository.PatientRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PatientServiceTest {

    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private PatientService patientService;

    @Test
    public void testSavePatient() {
        Patient patient = new Patient();
        patient.setName("John Doe");
        patient.setAge(25);

        when(patientRepository.save(patient)).thenReturn(patient);

        Patient result = patientService.savePatient(patient);

        assertEquals("John Doe", result.getName());


    }
    @Test
    public void testDeletePatient() {
        patientService.deletePatient(1L);
        verify(patientRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testGetAllPatients() {
        Patient p1 = new Patient();
        p1.setName("Alice");

        Patient p2 = new Patient();
        p2.setName("Bob");

        when(patientRepository.findAll()).thenReturn(List.of(p1, p2));

        List<Patient> result = patientService.getAllPatients();

        assertEquals(2, result.size());
    }

    @Test
    public void testGetPatientById() {
        Patient patient = new Patient();
        patient.setId(1L);
        patient.setName("Charlie");

        when(patientRepository.findById(1L)).thenReturn(Optional.of(patient));

        Patient result = patientService.getPatientById(1L);

        assertEquals("Charlie", result.getName());
    }


}