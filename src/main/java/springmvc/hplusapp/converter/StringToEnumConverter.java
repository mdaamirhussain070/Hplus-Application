package springmvc.hplusapp.converter;

import org.springframework.core.convert.converter.Converter;
import springmvc.hplusapp.bean.Gender;

public class StringToEnumConverter implements Converter<String,Gender> {


    @Override
    public Gender convert(String source) {
        if(source.equals("Male")){
            return Gender.Male;
        } else if (source.equals("Female")) {
            return Gender.Female;
        }
        else
            return Gender.Other;
    }

    @Override
    public <U> Converter<String, U> andThen(Converter<? super Gender, ? extends U> after) {
        return Converter.super.andThen(after);
    }
}
