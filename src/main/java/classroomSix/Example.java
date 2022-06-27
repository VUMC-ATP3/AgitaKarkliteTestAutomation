package classroomSix;

import com.github.javafaker.Faker;

public class Example {
    public static void main(String[] args) {
        System.out.println("This is Maven project");
        Employee employeeOne = new Employee("Janis", "Programmetajs", 100.32);
        System.out.println(employeeOne.toString());
        Faker faker = new Faker();
        Employee employeeTwo = new Employee(faker.name().firstName(), faker.company().profession(),
                faker.number().randomDouble(2,100,2000));
        System.out.println(employeeTwo.toString());
        System.out.println(faker.name().firstName());
        System.out.println(faker.name().lastName());
        System.out.println(faker.company().profession());
        System.out.println(faker.animal().name());
        System.out.println(faker.beer().style());
        System.out.println(faker.cat().breed());
        Employee employeeThree = new Employee();
        System.out.println(employeeThree);

        //uztaisīt ciklu, kas uztaisīs 100 jaunus employees un katru izvadīs uz ekrāna
//        for (int i = 0; i < 100; i++) {
//            Employee employeeN = new Employee();
//            System.out.println(employeeN.toString());
//        }




    }
}
