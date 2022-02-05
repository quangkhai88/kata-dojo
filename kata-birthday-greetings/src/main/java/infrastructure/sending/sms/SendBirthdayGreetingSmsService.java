package infrastructure.sending.sms;

import java.util.List;

import org.springframework.stereotype.Service;

import domain.SendBirthdayGreetingService;
import domain.User;


@Service
public class SendBirthdayGreetingSmsService implements SendBirthdayGreetingService{

	@Override
	public void sendBirthdayGreeting(User user) {
		System.out.println("Sending sms to " + user.getFirstName());
	}

	@Override
	public void sendBirthdayGreeting(List<User> users) {
		
	}

}
