T = int(input())

for t in range(T):
    A, B = map(int, input().split())
    result = -1
    if 0 < A < 10 and 0 < B < 10:
        result = A * B
        
    print('#' + str(t + 1), result)