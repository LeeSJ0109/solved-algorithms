T = int(input())

for t in range(T):
    N = int(input())

    a, N = divmod(N, 50000)
    b, N = divmod(N, 10000)
    c, N = divmod(N, 5000)
    d, N = divmod(N, 1000)
    e, N = divmod(N, 500)
    f, N = divmod(N, 100)
    g, N = divmod(N, 50)
    h, N = divmod(N, 10)
    
    print('#' + str(t + 1))
    print(a, b, c, d, e, f, g, h)