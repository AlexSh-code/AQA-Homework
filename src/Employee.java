public class Employee {
    public String fullName;
    private String position;
    private String email;
    private long phoneNumber;
    private int wage;
    private int age;

    public Employee(String fullName, String position, String email, long phoneNumber, int wage, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.wage = wage;
        this.age = age;
    }

    public Employee() {
        this.fullName = "Гордиенко Степан Михайлович";
        this.position = "Администратор";
        this.email = "gordstepan@gmail.com";
        this.phoneNumber = 89087635473L;
        this.wage = 91300;
        this.age = 27;
    }

    public void info() {
        System.out.println("ФИО: " + fullName + "; Должность: " + position + "; E-mail: " +
                email + "; Номер телефона: " + phoneNumber + "; Заработная плата: " + wage +
                "; Возраст: " + age);
    }



}
