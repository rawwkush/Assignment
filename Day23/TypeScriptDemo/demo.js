var Employee = /** @class */ (function () {
    function Employee(empid, ename, salary) {
        this.empid = empid;
        this.ename = ename;
        this.salary = salary;
    }
    Employee.prototype.getEmp = function () {
        return [{
                "empid": this.empid,
                "ename": this.ename,
                "salary": this.salary
            }];
    };
    return Employee;
}());
var e = new Employee(11, "Omkar", 2000);
console.log(e.getEmp());
