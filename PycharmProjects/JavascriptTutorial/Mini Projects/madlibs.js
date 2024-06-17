// Below is how to define a function in javascript

function wordblanks(noun,adjective,verb,adverb)
{
    var result = ""

    result += noun + " " + verb + " " + adjective + " " + adverb
    return result
}
console.log(wordblanks("dog","big","ran","quickly"))