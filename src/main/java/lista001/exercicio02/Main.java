package lista001.exercicio02;
import java.util.Scanner;

public class Main{
    private Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
        Main origin = new Main();
        Employee employee = origin.newEmployee();
        employee.show();
    }

    private String getNameEmployee(){
        System.out.println("Nome do funcionário: ");
        return scan.nextLine();
    }

    private String getPositionEmployee(){
        System.out.println("Cargo do funcionário: ");
        return scan.nextLine();
    }

    private Double getSalaryEmployee(){
        System.out.println("Salário do funcionário: ");
        while(!scan.hasNextDouble()){
            System.out.println("Valor inválido. Digite um novo: ");
            scan.next();
        }
        return scan.nextDouble();
    }

    public Employee newEmployee(){
        String name;
        String position;
        Double salary;

        name = this.getNameEmployee();
        position = this.getPositionEmployee();
        salary = getSalaryEmployee();

        return new Employee(name, position, salary);
    }
}