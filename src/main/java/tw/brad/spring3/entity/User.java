package tw.brad.spring3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data		// => Getter/Setter, toString
@NoArgsConstructor
public class User {
	private Integer id;
	private String name;
	private Boolean gender;
	private Integer age;
	
	
}
