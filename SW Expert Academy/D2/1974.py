def verification(table):
    for i in table:
        if len(set(i)) != 9:
            return 0
        
    for i in list(zip(*table)):
        if len(set(i)) != 9:
            return 0
        
    for i in range(0, 9, 3):
        for j in range(0, 9, 3):
            if len(set(table[i][j:j+3]+table[i+1][j:j+3]+table[i+2][j:j+3])) != 9:
                return 0
    return 1

T = int(input())

for t in range(T):
    table = [list(map(int, input().split())) for i in range(9)]

    print('#' + str(t + 1), verification(table))