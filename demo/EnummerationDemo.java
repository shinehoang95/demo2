package javademo.demo;

public class EnummerationDemo {

    public enum weekDay {

        MONDAY(2),
        TUESDAY(3),
        WEDNESDAY(4),
        THURSDAY(5),
        FRIDAY(6),
        SATURDAY(7),
        SUNDAY(0);
        private int n;

        weekDay(int a) {
            this.n = a;
        }
    }

    public static void main(String[] args) {
        weekDay d = weekDay.FRIDAY;
        switch (d) {
            case MONDAY:
                System.out.println("thu 2");
                break;
            case TUESDAY:
                System.out.println("thu 3");
                break;
            case WEDNESDAY:
                System.out.println("thu 4");
                break;
            case THURSDAY:
                System.out.println("thu 5");
                break;
            case FRIDAY:
                System.out.println("thu 6");
                break;
            case SATURDAY:
                System.out.println("thu 7");
                break;
            case SUNDAY:
                System.out.println("Chu nhat");
                break;
        }
    }
}
