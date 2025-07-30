package tw.brad.spring3.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserForm {
	@NotBlank(message = "Email 不可空")
	@Email(message = "請輸入有效Email")
	private String email;
	
	@Size(min = 6, message = "密碼長度 >= 6")
	private String passwd;
	
	@NotBlank(message = "name 不可空")
	private String name;
	
	
}
