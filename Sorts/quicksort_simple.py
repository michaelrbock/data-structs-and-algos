def quicksort(lst):
    if len(lst) <= 1:
        return lst
    pivot = lst.pop(len(lst)/2)
    less, greater = [], []
    for e in lst:
        if e < pivot:
            less.append(e)
        else:
            greater.append(e)
    return quicksort(less) + [pivot] + quicksort(greater)