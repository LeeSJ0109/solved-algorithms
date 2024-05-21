from collections import Counter

T = int(input())

for t in range(T):
    S = input()
    count = dict(Counter(S))

    print('#' + str(t + 1), end=' ')
    if list(count.values()) == [2, 2]:
        print("Yes")
    else:
        print("No")