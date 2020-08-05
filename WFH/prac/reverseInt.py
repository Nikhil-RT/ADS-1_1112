def revStr(a):
    if a[0]=='-':
        return '-'+a[:0:-1]
    else:
        return a[::-1]

print(revStr("-987"))
print(revStr("789"))
