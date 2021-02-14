"use strict";
exports.__esModule = true;
var Employee = /** @class */ (function () {
    function Employee(empid, ename, salary, medical) {
        if (empid === void 0) { empid = 0; }
        if (ename === void 0) { ename = ""; }
        if (salary === void 0) { salary = 0; }
        if (medical === void 0) { medical = 0; }
        this.empid = empid;
        this.ename = ename;
        this.salary = salary;
        this.medical = medical;
        this.HRA = 0.5 * this.salary;
        this.PF = 0.12 * this.salary;
        this.PT = 200;
    }
    Employee.prototype.calculateGrossSalary = function () {
        var val = this.salary + this.HRA + this.medical;
        return val;
    };
    Employee.prototype.calculateNetSalary = function () {
        var val = this.calculateGrossSalary() - (this.PT + this.PF);
        return val;
    };
    Employee.prototype.printEmployeeDetails = function () {
        var val = {
            "empid": this.empid,
            "ename": this.ename,
            "salary": this.salary,
            "grossSalary": this.calculateGrossSalary(),
            "netSalary": this.calculateNetSalary()
        };
        return val;
    };
    return Employee;
}());
exports.Employee = Employee;
//var e = new Employee(1, "Parth", 20000, 1000);
//console.log(e.printEmployeeDetails());
