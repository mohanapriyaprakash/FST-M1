
def calculate_sum(list):
   result=0
   for i in list:
    result+=i
   return result  

l=[10,20,40,60,80]

result=calculate_sum(l)
print("The sum of all the elements:"+str(result))