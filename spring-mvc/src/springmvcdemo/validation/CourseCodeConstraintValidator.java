package springmvcdemo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {
	
	private String prefix;
	@Override
	public void initialize(CourseCode courseCode) {
		prefix = courseCode.value();
	}
	@Override
	public boolean isValid(String code, ConstraintValidatorContext context) {
		boolean result;
		if(code!=null)
			result = code.startsWith(prefix);
		else 
			result = true;
		return result;
	}

}
