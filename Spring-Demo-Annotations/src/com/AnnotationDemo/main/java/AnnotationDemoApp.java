
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {
        // read the spring config file
        ClassPathXmlApplicationContext context =
                new  ClassPathXmlApplicationContext("applicationContext.xml");
        // get the bean from Spring Container
        Coach coach = context.getBean("baseballCoach",Coach.class);

        // call the method on bean
        System.out.println(coach.getDailyWorkout());

        //close context
        context.close();
    }
}
