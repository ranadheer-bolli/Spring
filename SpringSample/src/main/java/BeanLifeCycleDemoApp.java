import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new  ClassPathXmlApplicationContext("BeanLifeCycle-applicationContext.xml");
        // retrieve bean from spring container
        Coach coach1 = context.getBean("myCoach",Coach.class);

        //call methods on bean

        System.out.println(coach1.getDailyWorkout());

        context.close();


    }
}
