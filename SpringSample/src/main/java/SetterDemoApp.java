import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {
    public static void main(String[] args) {
        // load the configuration file
        ClassPathXmlApplicationContext context =
                new  ClassPathXmlApplicationContext("applicationContext.xml");
        // retrieve bean from spring container
        CricketCoach coach = context.getBean("myCricketCoach",CricketCoach.class);
        //call methods on bean
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());

        //  calling new methods to get literal values
        System.out.println(coach.getEmail());

        // close the context
        context.close();
    }
}
