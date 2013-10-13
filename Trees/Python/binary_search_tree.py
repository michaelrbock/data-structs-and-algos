class Node:
	def __init__(self, val):
		self.parent = None
		self.l_child = None
		self.r_child = None
		self.data = val

def binary_insert(root, node):
	if root is None:
		root = node
	else:
		if root.data > node.data:
			if root.l_child == None:
				root.l_child = node
				node.parent = root
			else:
				binary_insert(root.l_child, node)
		else:
			if root.r_child == None:
				root.r_child = node
				node.parent = root
			else:
				binary_insert(root.r_child, node)

def in_order_print(root):
	if not root:
		return
	in_order_print(root.l_child)
	print root.data
	in_order_print(root.r_child)

def pre_order_print(root):
	if not root:
		return
	print root.data
	pre_order_print(root.l_child)
	pre_order_print(root.r_child)

def find_min(root):
	current_node = root
	while current_node.l_child:
		current_node = current_node.l_child
	return current_node

def replace_node_in_parent(root, new_value=None):
	if root.parent:
		if root == root.parent.l_child:
			root.parent.l_child = new_value
		else:
			root.parent.r_child = new_value
	if new_value:
		new_value.parent = root.parent

def remove_node(root, key):
	if root is None:
		return False
	if key < root.data:
		remove_node(root.l_child, key)
	elif key > root.data:
		remove_node(root.r_child, key)
	else:
		if root.l_child and root.r_child:
			successor = find_min(root.r_child)
			root.data = successor.data
			remove_node(successor, successor.data)
		elif root.l_child: # only has left child
			replace_node_in_parent(root, root.l_child)
		elif root.r_child: # only has right child
			replace_node_in_parent(root, root.r_child)
		else:
			replace_node_in_parent(root, None)
