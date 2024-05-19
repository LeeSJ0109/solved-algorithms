day = ['SUN', 'SAT', 'FRI', 'THU', 'WED', 'TUE', 'MON']

T = int(input())

for t in range(T):
    S = input()
    
    result = day.index(S)
    if result == 0:
        result = 7
    print('#' + str(t + 1), result)