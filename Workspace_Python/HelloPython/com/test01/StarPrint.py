'''
1
*
**
***
****
*****
2
*****
****
***
**
*
3
    *
   **
  ***
 ****
*****
4
*****
 ****
  ***
   **
    *
5
    *
   ***
  *****
 *******
*********
'''
print('1')
for i in range(5):
    for i in range(i + 1):
        print('*', end='')
    print()
    
print('2')
for i in range(5, 0, -1):
    for i in range(i):
        print('*', end='')
    print()
'''
방법 2
for i in range(5):
    for j in range(5, i, -1):
        print('*', end='')
    print()
'''
    
print('3')
for i in range(5):
    for j in range(5):
        if j<4-i:
            print(' ', end='')
        else:
            print('*', end='')
    print()
'''
방법 2
for i in range(5):
    for j in range(5-i):
        print(' ', end='')
    for k in range(i+1):
        print('*', end='')
    print()
'''
    
print('4')
for i in range(5):
    for j in range(i):
        print(' ', end='')
    for k in range(5-i):
        print('*', end='')
    print()
    
print('5')
for i in range(5):
    for j in range(4-i):
        print(' ', end='')
    for k in range(1+2*i):
        print('*', end='')
    print()
    
print('6')
for i in range(5):
    for j in range(i):
        print(' ', end='')
    for k in range(9-2*i):
        print('*', end='')
    print()
for i in range(4):
    for j in range(3-i):
        print(' ', end='')
    for k in range(3+2*i):
        print('*', end='')
    print()
    
# pip install numpy
# pip install matplotlib

    