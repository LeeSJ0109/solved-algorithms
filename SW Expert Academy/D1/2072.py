T = int(input())

for t in range(T):
    num = list(map(int, input().split()))
    print('#' + str(t + 1), sum([i for i in num if i % 2]))