package net.blooddonor.bds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.blooddonor.bds.model.Donor;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Long>{

}
