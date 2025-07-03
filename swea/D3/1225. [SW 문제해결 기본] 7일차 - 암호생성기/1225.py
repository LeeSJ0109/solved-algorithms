def c(num):
    while True:
        for i in range(1, 6):
            p = num.pop(0)
            if p - i > 0:
                num.append(p - i)
            else:
                num.append(0)
                return num
         
for _ in range(10):
    T = int(input())
    num = list(map(int, input().split()))
 
    print('#' + str(T), *c(num))