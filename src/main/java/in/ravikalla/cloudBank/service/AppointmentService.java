package in.ravikalla.cloudBank.service;

import java.util.List;

import in.ravikalla.cloudBank.domain.Appointment;

public interface AppointmentService {
    
	Appointment createAppointment(Appointment appointment);

    List<Appointment> findAll();

    Appointment findAppointment(Long id);

    void confirmAppointment(Long id);
}
