// this file is giong to be about objects

var ourDog = {
    "Name": "Josiah",
    "legs counted": 4,
    "tails": 1,
    "friends": "everything"

}
// a way of using dot notation
var name = ourDog.Name;

// we have to use bracket notation if the property has a space in it
var legs = ourDog["legs counted"]


// Another Example
var Obj2 = {
    12: "Namath",
    16: "Montana",
    19: "Unitas"
}
var number = 16
var player = Obj2[number]
console.log(player)
console.log(delete Obj2["12"])


// in order to check if something has a property, do object.hasOwnProperty


// nested Objects
var myStorage = {
    "car": {
        "inside":{
            "glove box": "maps",
            "passenger seat": "crumbs"
        },
        "outside": {
            "trunk": "jack"
        }
    }
};

var gloveBoxContents = myStorage.car.inside["glove box"]
console.log(gloveBoxContents)


// nested arrays
var myPlants = [
    {
        type: "Flowers",
        list: [
            "rose",
            "tulip",
            "dandelion"
            ]
    },
    {
        type: "trees",
        list: [
            "fir",
            "pine",
            "birch"
        ]
    }
];
var Value = myPlants[1].list[0]
console.log(Value)