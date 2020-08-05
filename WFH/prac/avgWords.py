sentence1 = "this is a test"

def solution(sentence):
    delim = ".'?,;!:"
    for i in delim:
        sentence = sentence.replace(i,"")
    words = sentence.split()
    return round(sum(len(word) for word in words)/len(words),2)

print(solution(sentence1))
