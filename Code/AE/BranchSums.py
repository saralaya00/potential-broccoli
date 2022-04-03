# This is the class of the input root. Do not edit it.
class BinaryTree:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

def branchSums(root):
	sums = []
	helper(root, sums, 0)
	return sums

def helper(node, sums, runningSum):
	if node is None:
		return

	newRunningSum = runningSum + node.value

	if node.left is None and node.right is None:
		sums.append(newRunningSum)
		return

	helper(node.left, sums, newRunningSum)
	helper(node.right, sums, newRunningSum)
