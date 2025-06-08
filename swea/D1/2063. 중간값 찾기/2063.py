N = int(input())

num = list(map(int, input().split()))
num.sort()

N //= 2

print(num[N])