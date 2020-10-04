package example.one;

import java.util.Stack;

//caretaker
public class CareTaker {
    private Stack<EmployeeMemento> employeeHis=new Stack<EmployeeMemento>();

    public void save(Employee emp){
        employeeHis.push(emp.save());
    }

    public void revert(Employee emp){
        emp.revert(employeeHis.pop());
    }
}
