package com.example.demo.controller.userController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.deleteService.DeleteService;

@RestController
public class DeleteController {
	
@Autowired
DeleteService userDelete;

	
@RequestMapping(value="/deleteById",method=RequestMethod.GET)
public String deleteById(@RequestParam("id") Long id)
{
	String result=userDelete.deleteById(id);
	System.out.println(result);
	if(result=="success")
	return "success";
	return "error";
}
}
