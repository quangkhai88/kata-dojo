package infrastructure.data.file;

import domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserFileMapper {
	
	public User toUser(UserLine user) {
		return new User(user.getFirstName(), user.getLastName(), user.getEmail(), user.getBirthday());
	}

}
