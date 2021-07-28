public class CricketCoach implements Coach{
    private String email;
    private FortuneService fortuneService;
    public CricketCoach(){
        System.out.println("CricketCoach: Inside no-arg constructor");
    }

    public void setFortuneService(FortuneService fortuneService){
        System.out.println("Inside arg setter method");
        this.fortuneService = fortuneService;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return this.email;
    }
    @Override
    public String getDailyWorkout() {

        return "Practice Fast Bowling";
    }

    @Override
    public String getDailyFortune() {
        return this.fortuneService.getFortune();
    }
}
