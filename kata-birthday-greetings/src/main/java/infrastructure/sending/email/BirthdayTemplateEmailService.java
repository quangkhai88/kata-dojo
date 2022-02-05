package infrastructure.sending.email;

import domain.User;

public class BirthdayTemplateEmailService implements TemplateEmailService{

	@Override
	public String buildEmailBody(User user) {
		return  "Happy birthday " + user.getFullName() ;
	}

}
