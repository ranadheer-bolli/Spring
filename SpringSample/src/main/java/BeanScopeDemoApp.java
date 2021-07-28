import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new  ClassPathXmlApplicationContext("BeanScope-applicationContext.xml");
        // retrieve bean from spring container
        Coach coach1 = context.getBean("myCoach",Coach.class);

        Coach coach2 = context.getBean("myCoach",Coach.class);

        // check if they are same

        boolean result = (coach1 == coach2);
        System.out.println(result +" "+ coach1 +" "+ coach2);


        //call methods on bean


    }
}
