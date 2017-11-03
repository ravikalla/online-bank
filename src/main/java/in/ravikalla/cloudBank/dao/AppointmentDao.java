package in.ravikalla.cloudBank.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import in.ravikalla.cloudBank.domain.Appointment;

public interface AppointmentDao extends CrudRepository<Appointment, Long> {

    List<Appointment> findAll();
}
