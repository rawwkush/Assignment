class Employee{
    empid:number;
    ename:string;
    salary:number;

    constructor(empid, ename, salary){
        this.empid = empid;
        this.ename = ename;
        this.salary = salary;
    }

    getEmp(){
        return [{
            "empid":this.empid,
            "ename":this.ename,
            "salary":this.salary
        }];
    }
}

let e = new Employee(11, "Omkar", 2000);
console.log(e.getEmp());