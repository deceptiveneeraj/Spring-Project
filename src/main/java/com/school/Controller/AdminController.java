package com.school.Controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.entities.Admin;
import com.school.entities.Student;
import com.school.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
    @GetMapping("/about")
    public String getAdminInfo() {
        return "Hello, I am Admin";
    }
    
    @PostMapping("/post")
	public Admin createStudent(@RequestBody Admin admin){
		 return adminService.addAdmin(admin);
	}
	
	@GetMapping("/all")
	public Iterator<Admin> getAdmin(){
		 Iterator<Admin> ad=adminService.getAllAdmin();
		 return ad;
	}
	
	@GetMapping("/get/{id}")
	public Admin getSingleAdmin(@PathVariable int id){
		 Admin ad = adminService.getSingleAdmin(id);
		 //System.out.println(l);
		 return ad;
	}

	@PutMapping("/update")
	public Admin updateSingleAdmin(@RequestBody Admin admin){
		 return adminService.updateAdmin(admin); 
	}

	@DeleteMapping("/delete/{id}")
	public void deleteSingleAdmin(@PathVariable int id){
		  adminService.deleteAdmin(id);
	}
}
