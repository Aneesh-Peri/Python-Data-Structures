class BinarySearchTreeNode:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

    def add_child(self, data):
        if data == self.data:
            return

        if data < self.data:
            # add this value in the left subtree
            if self.left:
                self.left.add_child(data)
            else:
                self.left = BinarySearchTreeNode(data)
        else:
            if self.right:
                self.right.add_child(data)
            else:
                self.right = BinarySearchTreeNode(data)

    def in_order_traversal(self):
        elements = []

        # visiting left subtree first
        if self.left:
            elements += self.left.in_order_traversal()

        # visiting root node
        elements.append(self.data)

        # visiting right subtree
        if self.right:
            elements += self.right.in_order_traversal()

        return elements

    def pre_order_traversal(self):
        elements = []

        # visiting root node
        elements.append(self.data)

        # visiting left subtree first
        if self.left:
            elements += self.left.in_order_traversal()

        # visiting right subtree
        if self.right:
            elements += self.right.in_order_traversal()

        return elements

    def post_order_traversal(self):
        elements = []

        # visiting left subtree first
        if self.left:
            elements += self.left.in_order_traversal()

        # visiting right subtree
        if self.right:
            elements += self.right.in_order_traversal()

        # visiting root node
        elements.append(self.data)

        return elements

    def calculate_sum(self):
        left_value = 0
        right_value = 0
        if self.left:
            left_value += self.left.calculate_sum()
        else:
            left_value += 0

        if self.right:
            right_value += self.right.calculate_sum()
        else:
            right_value += 0

        return left_value + right_value

    def find_min(self):
        value = self.data
        if self.left is None:
            return self.data
        return self.left.find_min()

    def find_max(self):
        if self.right is None:
            return self.data
        return self.right.find_max()

    def search(self, val):
        if self.data == val:
            return True

        if val < self.data:
            if self.left:
                return self.left.search(val)
            else:
                return False

        if val > self.data:
            if self.right:
                return self.right.search(val)
            else:
                return False

    def delete(self, val):
        if val < self.data:
            if self.left:
                self.left = self.left.delete(val)
        elif val > self.data:
            if self.right:
                self.right = self.right.delete(val)
        else:
            if self.left is None and self.right is None:
                return None
            if self.left is None:
                return self.right
            if self.right is None:
                return self.left

            min_val = self.right.find_min()
            self.data = min_val
            self.right = self.right.delete(min_val)

        return self


def build_tree(elements):
    root = BinarySearchTreeNode(elements[0])
    for i in range(1, len(elements)):
        root.add_child(elements[i])

    return root


if __name__ == "__main__":
    numbers = [17, 4, 1, 20, 9, 23, 18, 34]
    number_tree = build_tree(numbers)
    number_tree.delete(20)
    print(number_tree.in_order_traversal())
