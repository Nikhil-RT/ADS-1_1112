import collections

def solution(string):
    freq = {}
    for i in string:
        if i not in freq:
            freq[i] = 1
        else:
            freq[i] += 1
    for i in range(len(string)):
        if freq[string[i]] == 1:
            return string[i]
    return -1

# print(solution("amazing"))
# print(solution1("amazing"))

def solution1(string):
    count = collections.Counter(string)
    print(count)
    for id,ch in enumerate(string):
        if count[ch] == 1:
            return ch
    return -1
print(solution1("amazing"))
