num = [i * j for i in range(1, 10) for j in range(1, 10)]

T = int (input())

for t in range(T):
    N = int(input())
    
    print('#' + str(t + 1), end=' ')
    
    if N in num:
        print("Yes")
    else:
        print("No")