def smallest_substring(s, t):

    if not s or not t:
        return ""

    needed = {}
    for char in t:
        if char in needed:
            needed[char] += 1
        else:
            needed[char] = 1

    left = 0  
    found = {}  
    have = 0    
    need = len(needed)  

    result = ""
    min_length = len(s) + 1  

    for right in range(len(s)):
        char = s[right]
        if char in found:
            found[char] += 1
        else:
            found[char] = 1

        if char in needed and found[char] == needed[char]:
            have += 1

        while have == need:
            window_size = right - left + 1
            if window_size < min_length:
                min_length = window_size
                result = s[left:right + 1]
            left_char = s[left]
            found[left_char] -= 1
            if left_char in needed and found[left_char] < needed[left_char]:
                have -= 1
            left += 1

    return result
s = "ADOBECODEBANC"
t = "ABC"
print(smallest_substring(s,t))
