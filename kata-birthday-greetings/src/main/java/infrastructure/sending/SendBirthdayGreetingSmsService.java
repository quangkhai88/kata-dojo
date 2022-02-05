package infrastructure.sending;

import java.util.List;

import domain.SendBirthdayGreetingService;
import domain.User;

public class SendBirthdayGreetingSmsService implements SendBirthdayGreetingService{

	@Override
	public void sendBirthdayGreeting(User user) {
		System.out.println("Sending sms to " + user.getFirstName());
	}

	@Override
	public void sendBirthdayGreeting(List<User> users) {
		
	}

}
