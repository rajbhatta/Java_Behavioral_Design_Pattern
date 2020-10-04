package example.one;

public class MementoDemo {
    public static void main(String [] args){

        CareTaker careTaker=new CareTaker();
        Employee emp=new Employee();

        emp.setName("Raj Bhatta");
        emp.setAddress("British Columbia");
        emp.setPhone("1112-2222-33");

        System.out.println("Employee before saving"+emp);

        careTaker.save(emp);

        emp.setPhone("444-4444-4444");

        System.out.println("Employee after changed phone number save"+emp);
        emp.setPhone("333-999-6666");

        careTaker.revert(emp);

        System.out.println("Revert to last save point: "+emp);
        careTaker.revert(emp);



    }
}
