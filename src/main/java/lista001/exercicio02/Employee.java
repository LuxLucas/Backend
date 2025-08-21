package lista001.exercicio02;

public class Employee{
    private String name;
    private String position;
    private Double salary;

    public Employee(String name, String position, Double salary){
        setName(name);
        setPosition(position);
        setSalary(salary);
    }

    public String getName(){
        return this.name;
    }

    public Double getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPosition(String position){
        this.position = position;
    }

    public void setSalary(Double salary){
        this.salary = salary;
    }

    public void show(){
        System.out.printf("""
                Nome: %s
                Cargo: %s
                Salário: %.2f
                """, getName(), getPosition(), getSalary());
    }
}