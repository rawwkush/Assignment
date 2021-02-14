export module demo{
    export function hello(){
        return "hello";
    }
    
    console.log(hello());
    
    let foo = ()=>{
        return "foo";
    }
    
    console.log(foo());
}