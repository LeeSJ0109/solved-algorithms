T = int(input())

for t in range(T):
    num = list(map(int, input().split()))
    result = round(sum(num) / 10, 0)
    print('#' + str(t + 1), int(result))