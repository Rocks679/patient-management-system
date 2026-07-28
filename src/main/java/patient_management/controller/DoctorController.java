package patient_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import patient_management.entity.Doctor;
import patient_management.service.DoctorService;

@Controller
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping("/doctors")
    public String listDoctor(Model model){
        model.addAttribute("doctors",doctorService.getAllDoctors());
        return "doctor";
    }

    @GetMapping("/doctors/new")
    public String showDoctorForm(Model model){
        model.addAttribute("doctor",new Doctor());
        return "doctor-form";
    }

    @PostMapping("/doctors/save")
    public String saveDoctor(@ModelAttribute Doctor doctor){
        doctorService.saveDoctor(doctor);
        return "redirect:/doctors";
    }

    @GetMapping("/doctors/delete/{id}")
    public String deleteDoctor(@PathVariable Long id){
        doctorService.deleteDoctor(id);
        return "redirect:/doctors";
    }


}
