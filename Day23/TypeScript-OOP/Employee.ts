export class Employee{
    empid:number;
    ename:string;
    salary:number;
    medical:number;
    PT:number;
    HRA:number;
    PF:number;

    constructor(empid:number=0, ename:string="", salary:number=0, medical:number=0){
        this.empid = empid;
        this.ename = ename;
        this.salary = salary;
        this.medical = medical
        this.HRA = 0.5 * this.salary;
        this.PF = 0.12 * this.salary;
        this.PT = 200;
    }

    calculateGrossSalary():number{
        let val:number = this.salary + this.HRA + this.medical
        return val;
    }

    calculateNetSalary():number{
        let val:number = this.calculateGrossSalary() - (this.PT + this.PF);
        return val;
    }

    printEmployeeDetails(){
        let val = {
            "empid":this.empid,
            "ename":this.ename,
            "salary":this.salary,
            "grossSalary":this.calculateGrossSalary(),
            "netSalary":this.calculateNetSalary()
        };
        return val;
    }
}


//var e = new Employee(1, "Parth", 20000, 1000);
//console.log(e.printEmployeeDetails());