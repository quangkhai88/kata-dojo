package infrastructure.data.oracle;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import domain.User;
import domain.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	private UserDbRepository userDbRepository;
	
	private UserDbMapper userDbMapper;
	
	@Override
	public List<User> getUsersByBirthday(LocalDate birthday) {
		return this.userDbRepository.findByBirthday(birthday).stream()
				.map(this.userDbMapper::toUser).collect(Collectors.toList());
	}

	@Override
	public List<User> getUsers() {
		return this.userDbRepository.findAll().stream()
				.map(this.userDbMapper::toUser).collect(Collectors.toList());
	}

	
}
