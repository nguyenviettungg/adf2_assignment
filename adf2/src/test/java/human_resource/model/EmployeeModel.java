package human_resource.model;

import human_resource.entity.Employees;
import human_resource.helper.ConnectionHelper;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeModel {
    private Scanner scanner;

    public EmployeeModel() {
    }


    public boolean register(Employees emp) {
        Scanner in = new Scanner(System.in);
        try {

            System.out.print("nhap ten:");
            String name = in.nextLine();
            System.out.print("nhap diachi:");
            String address = in.nextLine();
            System.out.print("nhap email:");
            String email = in.nextLine();
            System.out.print("username:");
            String username = in.nextLine();
            System.out.print("password:");
            String password = in.nextLine();
            System.out.print("ngay tao:");
            String dateCreated = in.nextLine();
            System.out.print("ngay update:");
            String dateUpdated = in.nextLine();
            System.out.print("trang thai(chon 1 de kich hoat):");
            int status = in.nextInt();

            String cmd = "insert into student (name ,address,email,username,password,dateCreated,dateUpdated,status) values (?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) ConnectionHelper.getConnection().prepareStatement(cmd);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,address);
            preparedStatement.setString(3,email);
            preparedStatement.setString(4,username);
            preparedStatement.setString(5,password);
            preparedStatement.setString(6,dateCreated);
            preparedStatement.setString(7,dateUpdated);
            preparedStatement.setInt(8, status);
            preparedStatement.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Khong the tao thong tin nguoi dung !!");
            return false;
        }

    }
    public ArrayList<EmployeeModel> loadList() {
        ArrayList list = new ArrayList();

        try {
            String cmd = "select * from accounts";
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(cmd);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String email = resultSet.getString("email");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String dateCreated = resultSet.getString("dateCreated");
                String dateUpdated = resultSet.getString("dateUpdated");
                int status = resultSet.getInt("status");
                
                Employees obj = new Employees(name, address, email, username,password,dateCreated,dateUpdated,status);
                list.add(obj);
            }
        } catch (Exception var11) {
            System.err.println("Không thể lấy dữ liệu từ database. Message: " + var11.getMessage());
        }

        return list;
    }
    public boolean checkExistAcc(String account) {
        try {
            String cmd = "select * from accounts where username = ?";
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(cmd);
            preparedStatement.setString(1,account);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String email = resultSet.getString("email");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String dateCreated = resultSet.getString("dateCreated");
                String dateUpdated = resultSet.getString("dateUpdated");
                int status = resultSet.getInt("status");

                Employees obj = new Employees(name, address, email, username,password,dateCreated,dateUpdated,status);

            }
            return true;
        } catch (Exception var12) {
            var12.getMessage();
            return false;
        }


    }
    public static Employees getByUsernameAndPassword(String usernamePara, String passwordPara) {
        try {
            String cmd = "select * from accounts where username = ? and password = ?";
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(cmd);
            preparedStatement.setString(1,usernamePara);
            preparedStatement.setString(2,passwordPara);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String email = resultSet.getString("email");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String dateCreated = resultSet.getString("dateCreated");
                String dateUpdated = resultSet.getString("dateUpdated");
                int status = resultSet.getInt("status");

                Employees obj = new Employees(name, address, email, username,password,dateCreated,dateUpdated,status);
                return  obj;
            }

        } catch (Exception var12) {
            System.err.println("Không thể lấy dữ liệu từ database. Message: " + var12.getMessage());

        }

        return null;
    }
    public Employees login() {
        System.out.println("Vui lòng nhập username: ");
        String username = this.scanner.nextLine();
        System.out.println("Vui lòng nhập password: ");
        String pwd = this.scanner.nextLine();
        return EmployeeModel.getByUsernameAndPassword(username, pwd);
    }
    private void printDetail(Employees employees) {
        if (employees == null) {
            System.out.println("Không tìm thấy account!");
        } else {
            employees.toString();
        }

    }


}
