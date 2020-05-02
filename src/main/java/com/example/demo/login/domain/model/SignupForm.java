package com.example.demo.login.domain.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SignupForm {
	
	@NotBlank(groups = ValidGroup1.class, message = "{require_check}")
    @Email(groups = ValidGroup2.class, message = "{email_check}")
	private String userId;
	
	@NotBlank(groups = ValidGroup1.class, message = "{require_check}")
    @Length(min=4, max=100, groups = ValidGroup2.class, message = "{length_check}")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", groups = ValidGroup3.class, message = "{pattern_check}")
	private String password;
	
	@NotBlank(groups = ValidGroup1.class, message = "{require_check}")
	private String userName;
	
	@NotNull(groups = ValidGroup1.class, message = "{require_check}")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date birthday;
	
	@Min(value = 20, groups = ValidGroup2.class, message = "{min_check}")
    @Max(value = 100, groups = ValidGroup2.class, message = "{max_check}")
	private BigDecimal age;
	
	@Pattern(regexp = "false", groups = ValidGroup3.class, message = "{false_check}")
	private String marriage;
}
