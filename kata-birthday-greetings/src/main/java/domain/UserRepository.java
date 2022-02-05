package domain;

import java.time.LocalDate;
import java.util.List;

public interface UserRepository {
	
	
	List<User> getUsersByBirthday(LocalDate birthday);
	
	List<User> getUsers();
	
	

}
