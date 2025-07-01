package sales.savvy.conrtoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sales.savvy.dto.LoginData;
import sales.savvy.entity.User;
import sales.savvy.service.UserService;

@CrossOrigin("*")
@RestController
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping("/tester")
	 public String tester(String username) {
	  System.out.println("req received: "+ username);
	  return "response fron 8080";
	 }
	
	@PostMapping("/signUp")
	public String signUp(@RequestBody User user) {
	    String username = user.getUsername();
	    User u = service.getUser(username);
	    
	    if (u != null) {
	    	return "Fali";
	    } else {
	    	service.addUser(user);
	    	return "Successfully SignUp";
	    }
	}
	
	@PostMapping("/signIn")
	public String signIn(@RequestBody LoginData data) {
		return service.validateUser(data);
	}


}
