"""
Beware, pseudocode ahead!
Breadth First Search
"""

class Node:
	def __init__(self, data):
		self.data = data
		self.adjacent = []
		self.visited = False

class Queue:
	def __init__(self):
		self._queue = []

	def enqueue(self, node):
		self._queue.append(node)

	def dequeue(self):
		if self._queue:
			return self._queue.pop(0)
		return None

	def is_empty(self):
		return len(self._queue) == 0

def bfs(root):
	queue = Queue()
	queue.enqueue(root)
	root.visited = True
	
	while not queue.is_empty():
		current = queue.dequeue()
		# if current is what we want:
		#	return current
		for node in current.adjacent:
			if not node.visited:
				node.visited = True
				queue.enqueue(node)
	# else
	return None