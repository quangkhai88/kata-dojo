package infrastructure.data.oracle;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserEntity {
	
    @Id
    @GeneratedValue(generator = "TODOSequenceGenerator")
    @Column(name = "id")
    private Integer id;
	
    @Column
	private String firstName;
	
    @Column
	private String lastName;
	
    @Column
	private String email;
	
    @Column
	private LocalDate birthday;	
}
