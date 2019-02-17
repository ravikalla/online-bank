package in.ravikalla.cloudBank.service.UserServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ravikalla.cloudBank.dao.AppointmentDao;
import in.ravikalla.cloudBank.domain.Appointment;
import in.ravikalla.cloudBank.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentDao appointmentDao;

    public Appointment createAppointment(Appointment appointment) {
       return appointmentDao.save(appointment);
    }

    public List<Appointment> findAll() {
        return appointmentDao.findAll();
    }

    public Optional<Appointment> findAppointment(Long id) {
        return appointmentDao.findById(id);
    }

    public void confirmAppointment(Long id) {
        Optional<Appointment> appointment = findAppointment(id);
        if (appointment.isPresent()) {
        	Appointment objAppointment = appointment.get();
        	objAppointment.setConfirmed(true);
	        appointmentDao.save(objAppointment);
        }
    }
}
