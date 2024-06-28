import time
import threading
from collections import deque


class Queue:
    def __init__(self):
        self._data = deque()

    def enqueue(self, data):
        self._data.appendleft(data)

    def dequeue(self):
        if len(self._data) == 0:
            print("Queue is empty")
        return self._data.pop()

    def isEmpty(self):
        return len(self._data) == 0

    def size(self):
        return len(self._data)


food_order_queue = Queue()


def place_orders(orders):
    for order in orders:
        time.sleep(0.5)
        food_order_queue.enqueue(order)


def serve_order():
    time.sleep(1)
    while True:
        value = food_order_queue.dequeue()
        print("Serving now: " + value)
        time.sleep(2)


if __name__ == "__main__":
    orders = ['pizza', 'samosa', 'pasta', 'biryani', 'burger']
    t1 = threading.Thread(target=place_orders(orders), args=(orders,))
    t2 = threading.Thread(target=serve_order(), args=(orders,))

    t1.start()
    t2.start()

    t1.join()
    t2.join()
