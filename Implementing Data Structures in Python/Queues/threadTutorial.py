# This exercise involves taking an input array and calculating
# squares and cubes of each value simultaneously
# Helper file for main exercise in queue_exercise.py

import time
import threading


def calc_square(values):
    for n in values:
        time.sleep(0.2)
        print('square: ' + str(n * n))


def calc_cube(values):
    for n in values:
        time.sleep(0.2)
        print('cube: ' + str(n * n * n))


arr = [2, 3, 8, 9]

t1 = threading.Thread(target=calc_square, args=(arr,))
t2 = threading.Thread(target=calc_cube, args=(arr,))

t1.start()
t2.start()

t1.join()
t2.join()
