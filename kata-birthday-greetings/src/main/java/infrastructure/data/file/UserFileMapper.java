package infrastructure.data.file;

import domain.User;

public class UserFileMapper {
	
	
	public User toUser(UserLine user) {
		return new User();
	}

}
