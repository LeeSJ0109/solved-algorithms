md = {1: 31, 2:28, 3:31, 4:30, 5:31, 6:30, 7:31, 8:31, 9:30, 10:31, 11:30, 12:31}

T = int(input())

for t in range(T):
    a, b, c, d = map(int, input().split())
    result = 0
    for i in range(a, c):
        result += md[i]
        
    print('#' + str(t + 1), result - b + 1 + d)