T = int(input())

for t in range(T):
    string = input()
    ball = string.count('(') + string.count(')') - string.count('()')

    print('#' + str(t + 1), ball)