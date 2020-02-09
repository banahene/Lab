public class MainApplication {

    public static void main(String[] args){
        Clock myClock = new Clock();

        while (true){
            System.out.println(myClock.showTime());
        }
    }
}
