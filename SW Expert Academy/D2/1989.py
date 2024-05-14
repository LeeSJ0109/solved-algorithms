T = int(input())

for t in range(T):
    w = input()
    p = 0
    if w == w[::-1]:
        p = 1
        
    print('#' + str(t + 1), p)