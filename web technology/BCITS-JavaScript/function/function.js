function add(a, b){
    var c=a+b;
    return c;
} 
var sum= add(10,20);
console.log('Sum is ',sum);
console.log("=========================================");

var n1=10;
var str= '10'
if(n1===str){
    console.log('Equal');
    
}else{
    console.log('Not equal');
    
}
console.log("==========================================");
console.log(typeof null);
console.log( typeof 10);
console.log(typeof 'hello');
console.log(typeof true);
var num = [10,20,30]
console.log(typeof num);
console.log(typeof undifined);


var isAry = Array.isArray(num)
if(isAry===true){
    console.log('num is a array')
    
}else{
    console.log('num is not a array')
    
}
console.log("============================================");
var addM = (a,b) => a+b;
var s =addM(10, 20);
console.log('Sum ',s);

var sqr= a=>a*a;
var n = sqr(20)
console.log(` Square is ${n}`);
console.log('=============================================');
console.log(`Square of 10 is ${10*10}`);























 

