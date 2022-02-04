package infrastructure.data.file;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import domain.User;
import domain.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	private UserFileRepository userDbRepository;
	
	private UserFileMapper userDbMapper;
	
	@Override
	public List<User> getTodayUsers() {
		return this.userDbRepository.findByBirthday(LocalDate.now()).stream()
				.map(this.userDbMapper::toUser).collect(Collectors.toList());
	}

	@Override
	public List<User> getUsers() {
		return this.userDbRepository.findAll().stream()
				.map(this.userDbMapper::toUser).collect(Collectors.toList());
	}

	
}
