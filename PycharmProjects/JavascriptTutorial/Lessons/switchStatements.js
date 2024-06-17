// this file will have an example of using switch statements

function switcher(val)
{
    var answer = ""
    switch(val)
    {
        case 1:
            answer = "alpha"
            break
        case 2:
            answer = "beta"
            break
        case 3:
            answer = "gamma"
            break
        case 4:
            answer="delta"
            break
        // if the value passed into the function has no case defined above, then the switch statement will default to the below statement
        default:
            answer = "huzzah"
            break
    }
    return answer
}

// return early pattern for functions
function abTest(a,b)
{
    if(a < 0 || b < 0)
    {
        return undefined; // you are basically just going to return early and exit a function early in a nutshell
    }

    return Math.round(Math.pow(Math.sqrt(a) + Math.sqrt(b),2))


}