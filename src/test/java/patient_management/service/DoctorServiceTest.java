package patient_management.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import patient_management.entity.Doctor;
import patient_management.repository.DoctorRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DoctorServiceTest {
    @Mock
    private DoctorRepository doctorRepository;
    @InjectMocks
    private DoctorService doctorService;

    @Test
    public void testSaveDoctor(){

        Doctor doctor = new Doctor();

        doctor.setName("ambi");
        doctor.setSpecialization("Cold Expert");

        when(doctorRepository.save(doctor)).thenReturn(doctor);

        Doctor result= doctorService.saveDoctor(doctor);

        assertEquals("ambi",result.getName());
        assertEquals("Cold Expert",result.getSpecialization());
    }

    @Test
    public void testDeleteDoctor(){
        doctorService.deleteDoctor(1L);
        verify(doctorRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testGetAllDoctor(){
        Doctor d1=new Doctor();
        d1.setName("Gowtham");

        Doctor d2=new Doctor();
        d2.setName("Dhivya");

        when(doctorRepository.findAll()).thenReturn(List.of(d1,d2));

        List<Doctor> result=doctorService.getAllDoctors();

        assertEquals(2,result.size());
    }

    @Test
    public void testGetDoctorById(){
        Doctor d1=new Doctor();
        d1.setId(1L);
        d1.setName("Dhivya");

        when(doctorRepository.findById(1L)).thenReturn(Optional.of(d1));

        Doctor resul = doctorService.getDoctorById(1L);

        assertEquals("Dhivya",resul.getName());
    }

}
