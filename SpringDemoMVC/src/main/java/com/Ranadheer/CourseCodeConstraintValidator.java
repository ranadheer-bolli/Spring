package com.Ranadheer;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode,String> {
    private String prefix;
    @Override
    public void initialize(CourseCode courseCode) {
             prefix=courseCode.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean result;
        if(s!=null)
            result = s.startsWith(prefix);
        else return true;
        return result;
    }

}
