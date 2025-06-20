from itertools import combinations as com
        
T = int(input())
p = []

for i  in range(10):
        q = []
        for j in range(i+1):
            q.append(len(list(com([i + 1 for i in range(i)], j))))
        p.append(q)
        
for t in range(T):
    N = int(input())
    print('#' + str(t + 1))
    for i in range(N):
        print(*p[i])