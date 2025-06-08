T = int(input())

for t in range(T):
    a, b = map(int, input().split())
    print('#' + str(t + 1), *divmod(a, b))