package infrastructure.data.oracle;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import domain.User;
import domain.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	private final UserDbRepository userDbRepository;
	
	private final UserDbMapper userDbMapper;

	@Autowired
	public UserRepositoryImpl(UserDbRepository userDbRepository, UserDbMapper userDbMapper) {
		this.userDbRepository = userDbRepository;
		this.userDbMapper = userDbMapper;
	}

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
