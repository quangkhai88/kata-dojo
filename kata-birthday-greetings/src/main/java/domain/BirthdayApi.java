package domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BirthdayApi {
	
	private UserRepository repository;
	
	private SendBirthdayGreetingService sendBirthdayGreeting;
	
	
	public void sendBirthdayGreeting(User user) {
		this.sendBirthdayGreeting.sendBirthdayGreeting(user);
	}
	
	public void sendTodayBirthdayGreeting() {
		List<User> users = this.repository.getTodayUsers();
		users.forEach(this::sendBirthdayGreeting);
	}
}
