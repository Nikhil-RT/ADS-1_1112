def val(s):
    s = s.lower()
    for i in range(len(s)):
        a = s[:i]
        print(a)
        t = s[:i]+s[i+1:]
        if t == t[::-1]:
            return True
    return False

print(val('RadkAr'))
