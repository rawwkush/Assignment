"use strict";
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
exports.__esModule = true;
var Employee_1 = require("./Employee");
var demooop_1 = require("./demooop");
var a;
a = [new Employee_1.Employee(1, "Gaurav", 70000),
    new Employee_1.Employee(2, "Parth", 75000),
    new Employee_1.Employee(3, "Anu", 72000)];
a.forEach(function (x) {
    console.log(x.printEmployeeDetails());
});
var AdvancedCalculator = /** @class */ (function (_super) {
    __extends(AdvancedCalculator, _super);
    function AdvancedCalculator() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    AdvancedCalculator.prototype.factorial = function (n) {
        var fact = 1;
        while (n > 0) {
            fact = fact * n;
            n--;
        }
        return fact;
    };
    AdvancedCalculator.prototype.div = function (a, b) {
        return a % b;
    };
    return AdvancedCalculator;
}(demooop_1.Calculator));
var c = new AdvancedCalculator();
console.log(c.factorial(5));
console.log(c.div(10, 3));
