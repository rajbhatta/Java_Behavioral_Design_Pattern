package example.one;

public class Employee {
    private String name;
    private String address;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toString(){
        return name+" :"+phone;
    }

    public EmployeeMemento save(){
        return new EmployeeMemento(name,phone);
    }

    public void revert(EmployeeMemento employeeMemento){
        this.name=employeeMemento.getName();
        this.phone=employeeMemento.getPhone();
    }
}
