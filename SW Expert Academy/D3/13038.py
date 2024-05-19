T = int(input())

for t in range(T):
    n = int(input())
    a = list(map(int, input().split()))
    case = []
    result = []

    for i in range(7):
        if a[i] == 1:
            case.append(a[i:] + a[:i])

    for c in case:
        i, stay, study = 0, 0, 0
        while True:
            i %= 7
            stay += 1
            if c[i]:
                study += 1     
            if study == n:
                result.append(stay)
                break
                
            i += 1

    print('#' + str(t + 1), min(result))