def Two_Sum(nums, target):
    l = 0
    r = len(nums) - 1
    while l < r:
        curr_sum = nums[l] + nums[r]
        if curr_sum == target:
            return [l + 1, r + 1] 
        elif curr_sum < target:
            left += 1 
        else:
            r -= 1  
    return []  

nums = [2, 7, 11, 15]
target = 9
print(Two_Sum(nums, target))
