package domain;

import java.util.List;

public interface UserRepository {
	
	
	List<User> getTodayUsers();
	
	List<User> getUsers();
	
	

}
