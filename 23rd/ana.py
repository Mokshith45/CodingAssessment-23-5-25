def anagrams(strs):
    ana = {}
    for word in strs:
        sorted_word = ''.join(sorted(word))  
        if sorted_word not in ana:
            ana[sorted_word] = []
        ana[sorted_word].append(word)
    return list(ana.values()) 

strs = ["eat", "tea", "bat", "cat"]
print(anagrams(strs))
