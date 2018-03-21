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
public void deleteById(@RequestParam("id") String id)
{
	userDelete.deleteById(id);
	
}
}
