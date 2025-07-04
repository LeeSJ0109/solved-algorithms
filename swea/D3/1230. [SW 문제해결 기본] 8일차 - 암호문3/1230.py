for T in range(1, 11):
    N = int(input())
    origin = input().split()
    M = int(input())
    command = input().split()

    i = 0
    for _ in range(M):
        if command[i] == 'I':
            x = int(command[i + 1])
            y = int(command[i + 2])
            i += 3

            cnt, tmp = 0, []
            while cnt < y:
                tmp.append(command[i])
                i += 1
                cnt += 1

            origin = origin[:x] + tmp + origin[x:]
            continue
        elif command[i] == 'D':
            x = int(command[i + 1])
            y = int(command[i + 2])
            i += 3

            origin = origin[:x] + origin[x + y:]
            continue
        elif command[i] == 'A':
            y = int(command[i + 1])
            i += 2

            cnt, tmp = 0, []
            while cnt < y:
                tmp.append(command[i])
                i += 1
                cnt += 1

            origin += tmp
            continue

    print('#' + str(T), *origin[:10])
