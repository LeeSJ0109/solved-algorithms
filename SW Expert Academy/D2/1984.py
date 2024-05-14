T = int(input())

for t in range(T):
    num = list(map(int, input().split()))
    print('#' + str(t + 1), int(round((sum(num) - max(num) - min(num)) / 8, 0)))