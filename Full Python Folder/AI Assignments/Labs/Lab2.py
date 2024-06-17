# Logic-2 Problems
# Make sure to shorten character count once done with all the problems
def make_bricks(small, big, goal):
    return goal % 5 <= small and goal - big * 5 <= small


def lone_sum(a, b, c):
    return 0 if a == b == c else c if a == b else b if a == c or b == c else a if a != b and a != c else 0


def lucky_sum(a, b, c):
    return a, b, c
