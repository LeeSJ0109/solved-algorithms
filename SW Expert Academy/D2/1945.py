T = int(input())

for t in range(T):
    N = int(input())
    a, b, c, d, e = 0, 0, 0, 0, 0
  
    while not N % 2:
        a += 1
        N //= 2
    while not N % 3:
        b += 1
        N //= 3
    while not N % 5:
        c += 1
        N //= 5
    while not N % 7:
        d += 1
        N //= 7
    while not N % 11:
        e += 1
        N //= 11
        
    print('#' + str(t + 1), a, b, c, d, e)