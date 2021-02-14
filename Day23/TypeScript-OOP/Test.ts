import {Employee} from "./Employee";
import {Calculator} from "./demooop";

var a:Employee[];

a= [new  Employee(1,"Gaurav", 70000), 
    new  Employee(2,"Parth", 75000),
    new  Employee(3,"Anu", 72000)];


a.forEach( x=>{
    console.log(x.printEmployeeDetails());
} );


class AdvancedCalculator extends Calculator{
    factorial(n):number{
        let fact=1;
        while(n>0){
            fact = fact * n
            n--;
        }
        return fact;
    }

    div(a,b){
        return a%b;
    }
}

var c = new AdvancedCalculator();

console.log(c.factorial(5));
console.log(c.div(10,3));


