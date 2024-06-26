T = int(input())

for t in range(T):
    P, Q, R, S, W = map(int, input().split())
    A = P * W
    
    B = Q
    if W > R:
        B += (W - R) * S
        
    print('#' + str(t + 1), min(A, B))