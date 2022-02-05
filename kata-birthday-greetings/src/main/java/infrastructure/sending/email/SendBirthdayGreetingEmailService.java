package infrastructure.sending.email;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.SendBirthdayGreetingService;
import domain.User;

@Service
public class SendBirthdayGreetingEmailService implements SendBirthdayGreetingService{

	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private BirthdayTemplateEmailService birthdayTemplateEmailService;
	
	
	@Override
	public void sendBirthdayGreeting(User user) {
		this.sendBirthdayGreetingEmail(user);
	}

	@Override
	public void sendBirthdayGreeting(List<User> users) {
		
		List<Callable<Integer>> tasks = new ArrayList<>();
		users.forEach(user -> {
			tasks.add(() -> {
				this.sendBirthdayGreetingEmail(user);
				return 1;
			});
		});
		
		ExecutorService executorService = Executors.newFixedThreadPool(20);
		try {
			executorService.invokeAll(tasks);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			executorService.shutdown();
		}
		
	}
	
	private void sendBirthdayGreetingEmail(User user) {
		
		System.out.println("Sending email to " + user.getEmail() + "...");
		
		String body = birthdayTemplateEmailService.buildEmailBody(user);
		emailService.sendBirthdayGreetingEmail(user.getEmail(), body);
	}

}
