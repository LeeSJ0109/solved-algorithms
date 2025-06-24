T = int(input())

for t in range(T):
    N = int(input())
    print('#' + str(t + 1), end=' ')
    if N % 2:
        print("Bob")
    else:
        print("Alice")