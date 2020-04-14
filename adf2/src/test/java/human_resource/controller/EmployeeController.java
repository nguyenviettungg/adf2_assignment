package human_resource.controller;

import human_resource.entity.Employees;
import human_resource.model.EmployeeModel;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeController {
    private EmployeeModel model = new EmployeeModel();
    private Scanner scanner;
    public EmployeeController() {
        this.scanner = new Scanner(System.in);
    }
    public ArrayList<EmployeeModel> getList() {
        return this.model.loadList();
    }
    public void dangky(){
        Employees emp = new Employees();
        if(this.model.register(emp)){
            System.out.println("Tao tai khoan thanh cong");
        }
    }
    public void  check(){
        System.out.println("nhap username:");
        String username = this.scanner.nextLine();
        if(this.model.checkExistAcc(username)){
            System.out.println("Tai khoan da ton tai.");
        }
    }
    public Employees login(){
        return this.model.login();
    }
}
