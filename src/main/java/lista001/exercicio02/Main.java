/*
    2. Estrutura de um Programa Java

    Exercício:
    Crie um programa que imprima os dados de um funcionário: nome completo, cargo e salário. Use System.out.println para cada informação.
    Exemplo de saída:

    Nome: Mariana Silva
    Cargo: Analista de Sistemas
    Salário: R$ 4500.00
 */

package lista001.exercicio02;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Main main = new Main();
        Employee employee = main.newEmployee();
        employee.show();
    }

    private String getNameEmployee(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Nome do funcionário: ");
        return scan.nextLine();
    }

    private String getPositionEmployee(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Cargo do funcionário: ");
        return scan.nextLine();
    }

    private Double getSalaryEmployee(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Salário do funcionário: ");
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