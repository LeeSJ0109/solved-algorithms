T = int(input())

for t in range(T):
    N = int(input())
    num = list(map(int, input().split()))
    num.sort()
    
    print('#' + str(t + 1), *num)