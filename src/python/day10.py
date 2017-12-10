input = [88,88,211,106,141,1,78,254,2,111,77,255,90,0,54,205]
list = [x for x in range(0,256)]
def process(arr, input, repeat):
	currentPos = 0
	skipSize = 0
	for d in range(repeat):
		for x in input:
			indizes = [x for x in range(currentPos,currentPos+x)]
			c = [arr[i % len(arr)] for i in indizes][::-1]
			for z in range(len(c)):
				arr[indizes[z]%len(arr)] = c[z]
			currentPos += x + skipSize
			skipSize += 1
process(list,input,1)
print("Part one: "+ str(list[0]*list[1]))

asciiCodes = '88,88,211,106,141,1,78,254,2,111,77,255,90,0,54,205'
asciiList = []
for i in range(len(asciiCodes)):
	asciiList.append(ord(asciiCodes[i]))
asciiList += [17,31,73,47,23]
list = [x for x in range(0,256)]
process(list,asciiList,64)
densehash = []

for x in range(16):
	temp = list[x*16:(x+1)*16]
	part = temp[0];
	for m in range(1,16):
		part ^= temp[m]
	hexnum = str(hex(part)[2:])
	if len(hexnum) == 1:
		hexnum = "0" + hexnum
	densehash.append(hexnum)

print("Part two: "+"".join(densehash))
