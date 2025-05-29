def longest_common_prefix(arr):
    if not arr:
        return ""
    prefix = arr[0]
    
    for word in arr[1:]:
        while not word.startswith(prefix):
            prefix = prefix[:-1]
            if prefix == "":
                return ""
    return prefix

arr = ['flower', 'flow', 'flost']
print(longest_common_prefix(arr))
