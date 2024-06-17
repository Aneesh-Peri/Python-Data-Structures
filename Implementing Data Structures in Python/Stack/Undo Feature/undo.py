def undo(str):
    lst = list(str)
    stack = []
    # Work on this part later
    try:
        num_char = int(input("Enter the number of letters you would like to remove: "))
        if num_char > len(lst):
            raise ValueError("Number of characters to remove exceeds the string length.")
    except ValueError as ve:
        print(f"Invalid input: {ve}")
        return

    # Remove the specified number of characters and push them onto the stack
    for _ in range(num_char):
        if lst:
            char = lst.pop()
            stack.append(char)
        else:
            break

    print(f"Modified list after undo operation: {lst}")
    print(f"Stack with removed characters: {stack}")

    # Reconstruct the modified string
    modified_text = ''.join(lst)
    print(modified_text)
    

undo("Hello")