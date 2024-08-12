package com.school.service;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.Repository.AdminRepository;
import com.school.entities.Admin;

@Service
public class AdminService {

	@Autowired
	AdminRepository adminRepository;
	
	public Admin addAdmin(Admin admin) {
		Admin ad = adminRepository.save(admin);
		return ad;
	}
	
	public Iterator<Admin> getAllAdmin(){
		Iterable iter=adminRepository.findAll();
		Iterator<Admin> itr=iter.iterator();
		return itr;
	}
	
	public Admin getSingleAdmin(int id){
		Optional<Admin> opt=adminRepository.findById(id);
		Admin ad = opt.get();
		return ad;
	}
	
	public Admin updateAdmin(Admin admin) {	
		return adminRepository.save(admin);
	}
	
	public void deleteAdmin(int id){
		Optional<Admin> opt= adminRepository.findById(id);
		Admin ad = opt.get();
		adminRepository.delete(ad); 
	}

}

