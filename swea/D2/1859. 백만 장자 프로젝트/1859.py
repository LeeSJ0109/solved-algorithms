T = int(input())

for t in range(T):
    N = int(input())
    price = list(map(int, input().split()))

    max_price = price[-1]
    profit = 0

    for i in range(1, N + 1):
        current_price = price[-i]
        if max_price > current_price:
            profit += max_price - current_price
        else:
            max_price = current_price
            
    print('#' + str(t + 1), profit)