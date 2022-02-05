package infrastructure.sending.email;

import domain.User;

public interface TemplateEmailService {
	
	public String buildEmailBody(User user);

	
}
