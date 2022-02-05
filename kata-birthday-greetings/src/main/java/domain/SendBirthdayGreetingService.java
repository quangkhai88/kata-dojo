package domain;

import java.util.List;

public interface SendBirthdayGreetingService {
	
	void sendBirthdayGreeting(User user);
	
	void sendBirthdayGreeting(List<User> users);

}
