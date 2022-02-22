package infrastructure.data.oracle;

import domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserDbMapper {
	
	public User toUser(UserEntity user) {
		return new User(user.getFirstName(), user.getLastName(), user.getEmail(), user.getBirthday());
	}

}
