// this file will be about using escape characters

// Using escape characters
var literalQuotes = "I am a \"double quoted\" string inside \"another double quoted string\""

// Another way to do the same thing but with single quotes
literalQuotes = 'I am a "double quoted" string inside "another doubled quoted string" plus '
var String2 = "Another string"

// another way to do concatenation
literalQuotes += String2

// to find length of a string
console.log(literalQuotes.length)

// using indices to find specific character in string
console.log(literalQuotes[0])
// Code below will help u find last character in string
console.log(literalQuotes[literalQuotes.length-1])

// Strings are immutable meaning that we can't go in and change an individual character of string
// But, we are able to change the string as a whole