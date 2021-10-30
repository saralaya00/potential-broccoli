// Manager
// Employee

// No of Employee under a manager
// Hierarchy of managers and Employee

// List <Map<emp ID, man ID>>
[{'empid': 1, 'mgrid':2}, {'empid': 2, 'mgrid':3}]
[
    {'empid': 1, 'mgrid':2}, 
    {'empid': 2, 'mgrid':3}, 
    {'empid': 3, 'mgrid':5}, 
    {'empid': 4, 'mgrid':5}, 
    {'empid': 5, 'mgrid':NONE}
] 
mgrid5 {3,4}
mgrid3 {2,}

managers {{2, 1}, {3, 1}, {5, 2}}
employeeCount {{1, 0}, {2, 1}, }

// identify all managers
// foreach manager
psvt {
    
    public void main () {
        Map<Integer, Integer> employees = Map.of(1,2, 2,3, 3,5, 4,5, 5,0);
        Map<Integer, Integer> managers = new HashMap();
        Map<Integer, Integer> employeeCount = new HashMap();

        for (Map.entry item: employees) {
            managers.merge(1, item.value, (prev) ->  (Integer) prev + 1);
        }

        for (Map.Entry item: employees.entrySet()) {
            employeeCount.merge((Integer)item.getKey(), 0, (k, v) -> {
                if (managers.contains(k)) {
                    //return v;
                    employeeCount.merge(k, v, Integer::sum);
                }
                else {

                }
            });
        }

        System.out.println(employeeCount);
    }
 }




 // Sol 1

// Find the No of Employees under a manager
// Find the Hierarchy of managers and Employee, such that a skipManager contains all his managers count and their Employees count
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        countEmp();
    }
    
    public static void countEmp () {
        Map<Integer, Integer> employees = Map.of(1,2, 2,3, 3,5, 4,5, 5,6, 6,6, 7,8); // Entry(empID, managerID)
        Map<Integer, Integer> managers = new HashMap();
        Map<Integer, Integer> employeeCount = new HashMap();

        for (Map.Entry item: employees.entrySet()) {
            managers.merge((Integer)item.getValue(), 1, Integer::sum);
        }

        System.out.println(managers);

        for (Map.Entry item: employees.entrySet()) {
            // Map.of(1,2, 2,3, 3,5, 4,5, 5,6, 6,6, 7,8);
            // {2 = 1, 3 = 1+f(2)==2, 5=2+f(3)==4, 6=1+f(5)+1==6, 8 = 1}
            // {2 = 1, 3 = 2, 5 = 4, 6 = 6, 8 = 1}
            
            // Map.of(1,2, 2,3, 3,5, 4,5, 5,6, 7,6); doesnt add f(5) to managerID = 6
            // {2=1, 3=1+f(2)=2, 5=2+f(3)=4, 6=2+f(5)=6}
            // {2=1, 3=2, 5=4, 6=6}
            boolean employeeIsManager = managers.containsKey(item.getKey());
            boolean isSkipManager = managers.containsKey(item.getValue());
            
            if (employeeIsManager) {
                employeeCount.merge((Integer)item.getKey(), (Integer)managers.get(item.getKey()), Integer::sum);
            }
            
            if (isSkipManager && employeeIsManager) {
                employeeCount.merge((Integer)item.getValue(), (Integer)managers.get(item.getValue()), Integer::sum);
            }
        }
        
        managers.forEach((k,v) ->  {
           if (!employeeCount.containsKey(k)) {
               employeeCount.put(k, v);
           } 
        });
        
        System.out.println(employeeCount);
    }
}