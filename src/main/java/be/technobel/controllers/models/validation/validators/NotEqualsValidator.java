package be.technobel.controllers.models.validation.validators;

import be.technobel.controllers.models.validation.constraints.NotEquals;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotEqualsValidator  implements ConstraintValidator<NotEquals, String> {

    private String notEqualsValue;

    @Override
    public void initialize(NotEquals constraintAnnotation){

        notEqualsValue = constraintAnnotation.value();


    }

    @Override
    public boolean isValid (String value, ConstraintValidatorContext context) {
        return !value.equals(notEqualsValue);
    }
}
