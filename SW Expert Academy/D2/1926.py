N = int(input())

for i in range(1, N + 1):
    i = str(i).replace('3', '-').replace('6', '-').replace('9', '-')
    if '-' in i:
        print('-' * i.count('-'), end=' ')
    else:
        print(i, end=' ')