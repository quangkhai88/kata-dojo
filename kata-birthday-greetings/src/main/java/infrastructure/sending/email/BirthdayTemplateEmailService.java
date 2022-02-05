package infrastructure.sending.email;

import domain.User;

public class BirthdayTemplateEmailService implements TemplateEmailService{

	@Override
	public String buildEmailText(User user) {
		return  "Happy birthday " + user.getFullName() ;
	}

}
