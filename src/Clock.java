import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Clock {
    private TimeDisplayFormat displayFormat;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
//    private List<Time> alarms = new ArrayList<>();

    public Clock(){
//        this.displayFormat = TimeDisplayFormat.TWENTYFOURHOUR;
        this. calendar = new GregorianCalendar();
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd   HH:mm:ss");         // Use 24 hour format by default
    }

    public void clearDate() throws Exception{
//        System.out.print(String.format("\033[2J"));
//        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public String showTime(){
        this.calendar.setTimeInMillis(System.currentTimeMillis());
        try{
            Thread.currentThread().sleep(1000);
        }catch (Exception e){}
        return dateFormat.format(this.calendar.getTime());
    }

    public boolean setDisplayFormat(TimeDisplayFormat dateTimeFormat){
        if (dateTimeFormat == TimeDisplayFormat.TWELVEHOUR){
            this.dateFormat = new SimpleDateFormat("yyyy-MM-dd   hh:mm:ss");
            return true;
        }else if (dateTimeFormat == TimeDisplayFormat.TWENTYFOURHOUR){
            this.dateFormat = new SimpleDateFormat("yyyy-MM-dd   HH:mm:ss");
            return true;
        }
        return false;
    }
//
//    public boolean setAlarm(){
//    }
//
//    public void soundAlarm(){
//
//    }

    public static void main(String[] args){
        Clock myClock = new Clock();
        myClock.setDisplayFormat(TimeDisplayFormat.TWELVEHOUR);


        int count = 0;
        while (count < 60){
            try{
                System.out.println(myClock.showTime());
                Thread.currentThread().sleep(1000);
            }catch (Exception e) {// Do nothing
            }
        }

    }

    //----------------------------------------------Helper Stuff ------------------------------

    public enum TimeDisplayFormat { TWENTYFOURHOUR, TWELVEHOUR }
}
