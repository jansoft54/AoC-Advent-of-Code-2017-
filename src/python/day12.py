dict = {}
enc = ['0']
groups = 0

with open("day12.txt") as file:
	for line in file.readlines():
		dict[(line.split("<->")[0]).replace(" ","")] = ((line.split("<->")[1])).replace(" ", "").replace("\n","").split(",")

def calc(next):
	l = dict[next]
	l = [x for x in l if x not in enc]
	for d in l:
		if d not in enc: #strange recursion thing seems redundant but isn`t
			enc.append(d)
			calc(d)

def remove():
	global enc
	for i in enc:
		dict.pop(i)
	for x in dict:
		enc =[x]
		return

calc('0')
print("Part one: "+str(len(enc)))
while dict:
	calc(enc[0])
	remove()
	groups +=1
print("Part two: "+str(groups))


	
