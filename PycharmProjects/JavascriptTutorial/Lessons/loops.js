// this file is about loops

var myArray = []

var i = 0
while(i<5)
{
    myArray.push(i)
    i++;
}
console.log(myArray)



// for loops
for(var i = 0; i < 5; i++)
{
    console.log(myArray[i])
}

// do ... while loops
do {
    {
       myArray.push(i)
       i++
    }
} while(i<5)

console.log(i,myArray)


// ternary operators
// condition ? statement-if-true : statement-if-false
function checkEqual(a,b)
{
    return a === b ? true : false
}