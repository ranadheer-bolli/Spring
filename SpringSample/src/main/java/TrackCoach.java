public class TrackCoach implements Coach{

    private FortuneService fortuneService;
    public TrackCoach(FortuneService fortuneService){
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Sprint for 30 mins";
    }

    @Override
    public String getDailyFortune() {
        return this.fortuneService.getFortune();
    }

    // add an init method
    public void doInitMethod(){
        System.out.println("Inside Init method");
    }

    // add an destroy method
    public void doDestroyMethod(){
        System.out.println("Inside Destroy method");
    }


}
