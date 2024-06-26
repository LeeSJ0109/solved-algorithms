T = int(input())

for t in range(T):
    a, b = map(int, input().split())
    print('#' + str(t + 1), end = '')
    if a > b:
        print(' >')
    elif a < b:
        print(' <')
    else:
        print(' =')