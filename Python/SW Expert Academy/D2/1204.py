from collections import Counter

T = int(input())

for _ in range(T):
    t = input()
    num = list(map(int, input().split()))

    c = Counter(num)
    print('#' + t, c.most_common(1)[0][0])