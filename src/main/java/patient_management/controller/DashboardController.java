package patient_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import patient_management.service.PatientService;
import patient_management.service.DoctorService;
import patient_management.service.AppointmentService;

@Controller
public class DashboardController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        model.addAttribute("totalPatients", patientService.getAllPatients().size());
        model.addAttribute("totalDoctors", doctorService.getAllDoctors().size());
        model.addAttribute("totalAppointments", appointmentService.getAllAppointments().size());
        return "dashboard";
    }
}