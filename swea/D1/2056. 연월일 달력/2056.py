T = int(input())

for t in range(T):
    ymd = input()
    y, m, d = ymd[:4], ymd[4:6], ymd[6:8]
    print('#' + str(t + 1), end =' ')
    if int(m) == 0 or int(m) > 12 or int(d) == 0 or int(d) > 31:
        print(-1)
    elif int(m) == 2 and int(d) > 28:
        print(-1)
    elif int(m) in [1, 3, 5, 7, 8, 10, 12] and int(d) > 31:
        print(-1)
    elif int(d) > 30:
        print(-1)
    else:
    	print(y, m, d, sep='/')