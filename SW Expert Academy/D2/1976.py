T = int(input())

for t in range(T):
    h1, m1, h2, m2 = map(int, input().split())

    m = (h1 + h2) * 60 + m1 + m2
    h, m = divmod(m, 60)

    if h >= 12:
        h %= 12
    if h == 0:
        h = 12

    print('#' + str(t + 1), h, m)