package infrastructure.sending.sms;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.stereotype.Service;

import domain.SendBirthdayGreetingService;
import domain.User;


@Service
public class SendBirthdayGreetingSmsService implements SendBirthdayGreetingService{

	@Override
	public void sendBirthdayGreeting(User user) {
		System.out.println("Sending sms to " + user.getFullName());
	}

	@Override
	public void sendBirthdayGreeting(List<User> users) {
		ExecutorService executorService = Executors.newFixedThreadPool(20);

		List<Callable<String>> tasks = new ArrayList<>();
		users.forEach(user -> {
			Callable<String> sendSmsCallable = () -> {
				System.out.println("Sending sms to " + user.getFullName());
				return user.getFullName();
			};
			tasks.add(sendSmsCallable);
		});
		try {
			executorService.invokeAll(tasks);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			executorService.shutdown();
		}
	}

}
