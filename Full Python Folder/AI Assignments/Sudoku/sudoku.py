# Below is a function for reading in a file
print("When printed, the 0's represent empty spots")
def sudoku_file_reader():
    try:
        # Trying code to open the file
        with open(input("Enter the name of the sudoku puzzle: "),'r') as file:
            print(f'Sudoku Puzzle: \n{file.read()}')
    except Exception as e:
        print(f'The following code will not work with the file due to a {e} error')

