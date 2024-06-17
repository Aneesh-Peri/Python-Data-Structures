// this file is going to be about arrays
var ourArray = ["John",23]
console.log(ourArray)

// Below is an example of a nested array
var myArray = [["position",42],["order",21]]

// Accessing values in arrays with indices
console.log(myArray[0])

// modifying values in an array
myArray[0]=45
console.log(myArray)

// how to add values to an array
myArray.push(["happy","joy"])
console.log(myArray)

// how to remove values from an array
console.log(myArray.pop())

// how to remove first value from array, pop removes last
console.log(myArray.shift())

// another way to add to array
myArray.unshift(["huzzah",33])
console.log(myArray)

