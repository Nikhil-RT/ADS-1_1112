def sol(num):
    return (all(num[i] <= num[i+1] for i in range(len(num) - 1)) or
    all(num[i] >= num[i+1] for i in range(len(num) - 1)))
print(sol([1,2,3,4,5,4]))
