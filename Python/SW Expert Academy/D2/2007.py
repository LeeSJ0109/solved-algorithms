T = int(input())

for t in range(T):
    w = input()

    for i in range(11):
        if w[0:i+1] == w[i+1:2*(i+1)]:
            print('#' + str(t + 1), i + 1)
            break