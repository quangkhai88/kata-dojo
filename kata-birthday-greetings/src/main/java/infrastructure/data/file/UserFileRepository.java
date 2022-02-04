package infrastructure.data.file;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


public class UserFileRepository {
	
	
	public List<UserLine> findByBirthday(LocalDate birthday){
		return findAll().stream().filter(e -> e.getBirthday().equals(birthday)).collect(Collectors.toList());
	}
	
	public List<UserLine> findAll(){
		return readFromFile();
	}

	private List<UserLine> readFromFile() {
		return null;
	}

}
