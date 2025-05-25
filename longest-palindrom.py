def is_palindrome(s):
    return s == s[::-1]
    
def longest_palindrome(s):
    longest = ""
    n = len(s)
    for i in range(n):
        for j in range(i+1, n):
            substring = s[i:j]
            if is_palindrome(substring) and len(substring) > len(longest):
                longest = substring
    return longest

s = "abbabcsa"
print(longest_palindrome(s))
    
