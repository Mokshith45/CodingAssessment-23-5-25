def subarray_sum(nums, k):
	count = 0
	n = len(nums)
	for start in range(n):
		current_sum = 0
		for end in range(start, n):
			current_sum += nums[end]
			if current_sum == k:
				count += 1
	return count 
nums = [1,2,3,4,5,6,7,8]
k = 5
print(subarray_sum(nums,k))
