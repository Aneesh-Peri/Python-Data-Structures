var collection = [
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

var CollectionCopy = JSON.parse(JSON.stringify(collection))

function updateRecords(id,prop,value)
{
    if(value=== "")
    {
        delete collection[id][prop];
    }
    else if(prop==="tracks")
    {
        collection[id][prop] = collection[id][prop] || []
        collection[id][prop].push(value)
    }
    else
    {
        collection[id][prop] = value
    }
    return collection
}
console.log()