def valid_paranthesis(s):
    stack = []
    for cha in s:
        if cha == "(" or cha == "{" or cha == "[":
            stack.append(cha)
        else:
            if not stack:
                return False
            if cha == ")" and stack[-1] == "(":
                stack.pop()
            elif cha == "}" and stack[-1] == "{":
                stack.pop()
            elif cha == "]" and stack[-1] == "[":
                stack.pop()
            else:
                return False
    return not stack
    
s = "(){}[]"
print(valid_paranthesis(s))
