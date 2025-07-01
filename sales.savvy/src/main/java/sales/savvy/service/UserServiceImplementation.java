package sales.savvy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sales.savvy.dto.LoginData;
import sales.savvy.entity.User;
import sales.savvy.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {
	
	@Autowired
	UserRepository repo;

	@Override
	public void addUser(User user) {
		repo.save(user);
	}
	
	
	@Override
	public User getUser(String username) {
		return repo.findByUsername(username);
	}


	@Override
	public String validateUser(LoginData data) {
		String webUsername = data.getUsername();
		String webPassword = data.getPassword();
		
		User u = getUser(webUsername);
		//username does not exist in db
		if(u == null) {
			return "User Name and Password not Properly Typed, Or Null Typed.";
		}
		//username exists in db
		else {
			String dbPassword = u.getPassword();
			//valid credentials
			if(webPassword.equals(dbPassword)) {
				String role = u.getRole();
				if(role.equalsIgnoreCase("admin"))
					return "Admin User";
				else
					return "Customer User";
			}
			//invalid credentials
			else
				return "Wrong Credential, UserName or Password Mismatched.";
		}
	}
	
}
