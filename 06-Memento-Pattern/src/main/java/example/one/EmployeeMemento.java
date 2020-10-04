package example.one;

//memento: we have control over the employee fields because we excluded address
public class EmployeeMemento {

    private String name;
    private String phone;

    //Set the state of Employee
    public EmployeeMemento(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    //get the state of Employee
    public String getName() {
        return name;
    }

    //get the state of Employee
    public String getPhone() {
        return phone;
    }


}
