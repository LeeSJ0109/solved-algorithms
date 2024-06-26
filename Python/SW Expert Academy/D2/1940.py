T = int(input())

for t in range(T):
    d, ac = 0, 0

    N = int(input())
    for _ in range(N):
        command = list(map(int, input().split()))
        if command[0] == 1:
            ac += command[1]
        elif command[0] == 2:
            if ac - command[1] < 0:
                ac = 0
            else:
                ac -= command[1]
        d += ac        

    print('#' + str(t + 1), d)