T = int(input())

for t in range(T):
    string = input().upper()

    result = 0
    for i in range(len(string)):
        if chr(i + 65) == string[i]:
            result += 1
        else: break

    print('#' + str(t + 1), result)