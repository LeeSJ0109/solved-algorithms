T = int(input())

for t in range(T):
    a, b = 1, 1
    string = input()

    for s in string:
        if s == 'L':
            b += a
        elif s == 'R':
            a += b
            
    print('#' + str(t + 1), a, b)