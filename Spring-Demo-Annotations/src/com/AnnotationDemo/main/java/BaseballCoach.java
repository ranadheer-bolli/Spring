import org.springframework.stereotype.Component;

@Component("baseballCoach")
public class BaseballCoach implements Coach {

    @Override
    public String getDailyWorkout(){
        return  "Practice batting for 30 mins";
    }

}
