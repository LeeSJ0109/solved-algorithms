TC = int(input())

for T in range(TC):
    N = int(input())
    price = list(map(int, input().split()))
    sale = []

    for i in range(N):
        if int(price[i] / 3 * 4) in price:
            sale.append(price[i])
            price.pop(price.index(price[i] / 3 * 4))

    print('#' + str(T + 1), *sale)