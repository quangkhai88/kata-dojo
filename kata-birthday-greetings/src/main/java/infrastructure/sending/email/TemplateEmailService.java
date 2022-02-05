package infrastructure.sending.email;

import domain.User;

public interface TemplateEmailService {
	
	public String buildEmailText(User user);

	
}
