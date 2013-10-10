"""
Beware, pseudocode ahead!
Depth First Search
"""

class Node:
	def __init__(self, data):
		self.data = data
		self.adjacent = []
		self.visited = False

def search(root):
	if not root:
		return
	root.visited = True
	for node in root.adjacent:
		if not node.visited:
			search(node)
