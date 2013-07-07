def merge(left, right):
	result = []

	# continue assigning elements to result until left and right are empty
	while len(left) > 0 or len(right) > 0:
		# if there are elements in both lists
		if len(left) > 0 and len(right) > 0:
			# compare the first elements of each list
			if left[0] <= right[0]:
				# append the smaller element to the result list
				result.append(left.pop(0))
			else:
				result.append(right.pop(0))
		# if one array is empty, append the other one in its entirety to result
		elif len(left) > 0:
			result.append(left.pop(0))
		elif len(right) > 0:
			result.append(right.pop(0))
	# end while
	return result

def merge_sort(lst):
	# if list size is empty or 1, it is sorted and return it
	if len(lst) <= 1:
		return lst

	# else, list size is > 1, so split into 2 sublists
	# 1. Divide
	middle = len(lst) / 2 # integer
	left = lst[:middle]
	right = lst[middle:]
	
	# recursively call merge_sort on each list
	left = merge_sort(left)
	right = merge_sort(right)

	# 2. Conquer
	return merge(left, right)
