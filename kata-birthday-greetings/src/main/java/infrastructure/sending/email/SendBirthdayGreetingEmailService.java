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
	
	
	@Override
	public void sendBirthdayGreeting(User user) {
		System.out.println("Sending email to " + user.getEmail());
	}

	@Override
	public void sendBirthdayGreeting(List<User> users) {
		
		List<Callable<Integer>> tasks = new ArrayList<>();
		users.forEach(user -> {
			tasks.add(() -> {
				System.out.println("Sending email to "+user.getEmail() + "...");
				emailService.sendBirthdayGreetingEmail(user.getEmail());
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

}
