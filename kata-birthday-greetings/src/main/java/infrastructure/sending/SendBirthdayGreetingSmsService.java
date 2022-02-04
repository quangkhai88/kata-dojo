package infrastructure.sending;

import domain.SendBirthdayGreetingService;
import domain.User;

public class SendBirthdayGreetingSmsService implements SendBirthdayGreetingService{

	@Override
	public void sendBirthdayGreeting(User user) {
		System.out.println("Sending sms to " + user.getFirstName());
	}

}
