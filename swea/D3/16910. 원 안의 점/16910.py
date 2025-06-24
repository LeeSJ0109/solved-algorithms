T = int(input())

for t in range(T):
    N = int(input())

    cnt = 0
    for x in range(-200, 201):
        for y in range(-200, 201):
            if x ** 2 + y ** 2 <= N ** 2:
                cnt += 1
    print('#' + str(t + 1), cnt)