package infrastructure.data.file;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLine {
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private LocalDate birthday;	
	
}
