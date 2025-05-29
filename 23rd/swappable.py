def swapable(w1,w2):
    if len(w2) != len(w1):
        return False
    un_w1 = set(w1)
    un_w2 = set(w2)
    return sorted(un_w1) == sorted(un_w2)

w1 = "abbzzca"
w2 = "babzzcz"
print(swapable(w1, w2))
