package net.blooddonor.bds.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.blooddonor.bds.exception.ResourceNotFoundException;
import net.blooddonor.bds.model.Donor;
import net.blooddonor.bds.repository.DonorRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")	//localhost if using only locally, else use *
public class DonorController {
	
	@Autowired
	private DonorRepository donorRepository;
	
	//get All donors
	@GetMapping("/donors")
	public List<Donor> getAllDonors()
	{
		System.out.println("Got All donors...");
		return donorRepository.findAll();	//returns list of donors to cl
	}
	
	//create donor rest api
	@PostMapping("/donors")
	public Donor createDonor(@RequestBody Donor donor)
	{
		System.out.println("In Post Mapping: ");
		System.out.println(donor.toString());
		return donorRepository.save(donor);
	}
	
	//get donor by id rest api
	@GetMapping("/donors/{id}")
	public ResponseEntity<Donor> getDonorById(@PathVariable Long id)
	{
		Donor donor = donorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Donor doesn't exist : "+ id));
		System.out.println("Get Mapping");
		System.out.println(donor);
		System.out.println(id);
		return ResponseEntity.ok(donor);
	}
	
	//update donor rest api
	@PutMapping("/donors/{id}")
	public ResponseEntity<Donor> updateDonor(@PathVariable Long id, @RequestBody Donor donorDetails)
	{
		Donor donor = donorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Donor n't found with id : "+id));
		System.out.println("In Put Mapping : ");
		System.out.println(donor.toString());
		System.out.println("Id : "+id);
		System.out.println("Donor details : "+donorDetails);
		donor.setName(donorDetails.getName());
		donor.setSex(donorDetails.getSex());
		donor.setAge(donorDetails.getAge());
		donor.setBloodGroup(donorDetails.getBloodGroup());
		donor.setLastDonation(donorDetails.getLastDonation());
		
		Donor updatedDonor = donorRepository.save(donor);
		System.out.println("Updated Donor : "+updatedDonor);
		return ResponseEntity.ok(updatedDonor);
	}
	
	//delete donor rest api
	@DeleteMapping("/donors/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteDonor(@PathVariable Long id){
		Donor donor = donorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Donor n't exist with id : "+id));
		donorRepository.delete(donor);
		Map<String,Boolean> response = new HashMap<>();	//To return msg deleted as TRUE
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
