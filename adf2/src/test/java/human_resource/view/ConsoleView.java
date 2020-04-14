package human_resource.view;

import human_resource.controller.EmployeeController;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleView {
    private EmployeeController controller = new EmployeeController();
    private Scanner scanner;
    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }
    public void generateMenu(){
        int choice;
        do {
            System.out.println("------------Employees Management-----------");
            System.out.println("1.Đăng ký tài khoản.");
            System.out.println("2.Kiểm tra tài khoản .");
            System.out.println("3.Đăng nhập .");
            System.out.println("-------------------------------------");
            System.out.println("Vui lòng nhập lựa chọn của bạn (1 đến 3) : ");
            choice = this.scanner.nextInt();
            this.scanner.nextLine();
            switch(choice) {
                case 1:
                    this.controller.dangky();
                    break;
                case 2:
                    this.controller.check();
                    break;
                case 3:
                    this.controller.login();
                    break;
                default:
                    System.out.println("Vui lòng lựa chọn trong khoảng từ 1 đến 3.");
            }
        } while(choice != 3);
    }
}
