package infrastructure.data.oracle;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDbRepository extends JpaRepository<UserEntity, Integer>{
	
	public List<UserEntity> findByBirthday(LocalDate birthday);

}
