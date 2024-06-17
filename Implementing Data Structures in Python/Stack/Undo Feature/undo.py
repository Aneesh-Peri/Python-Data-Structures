def undo(str):
    lst = []
    stack = []
    for i in str:
        lst.append(i)
    print(lst)
    numChar = int(input("Enter the number of letters you would like to remove: "))
    i = 0
    print(lst.pop() + " popped later")
    # Work on this part later
    while i < numChar:
        stack.append(i)
    print(stack)
    

undo("Hello")