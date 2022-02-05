package infrastructure.sending;

import java.util.List;

import domain.SendBirthdayGreetingService;
import domain.User;

public class SendBirthdayGreetingEmailService implements SendBirthdayGreetingService{

	@Override
	public void sendBirthdayGreeting(User user) {
		System.out.println("Sending email to " + user.getEmail());
	}

	@Override
	public void sendBirthdayGreeting(List<User> users) {
		
	}

}
