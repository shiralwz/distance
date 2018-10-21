# distance
## Run the main in Test class
1)Run the main in Test class
2)Specify the file path of the station graph, or just press "Enter" to use the default file path within the project.
You will see

The Adjacent Matrix: 
```
           A     B     C     D     E     F     G     H     I     J
     A     0    12   INF    19    20   INF    16   INF   INF   INF
     B   INF     0     5    13   INF   INF   INF   INF    15   INF
     C   INF   INF     0     5   INF   INF   INF   INF   INF   INF
     D   INF   INF   INF     0     7   INF   INF   INF   INF   INF
     E   INF   INF   INF   INF     0     5   INF   INF   INF   INF
     F     5   INF   INF   INF   INF     0   INF   INF   INF   INF
     G   INF   INF   INF   INF   INF    11     0   INF   INF   INF
     H     4    19   INF   INF   INF   INF     6     0   INF   INF
     I   INF   INF   INF   INF   INF   INF   INF    21     0    10
     J   INF     7    15   INF   INF   INF   INF   INF   INF     0
```     

The Final Path Matrix: 
```
           A     B     C     D     E     F     G     H     I     J
     A     0     1     1     3     4     4     6     1     1     1
     B     2     1     2     2     2     2     8     8     8     8
     C     3     3     2     3     3     3     3     3     3     3
     D     4     4     4     3     4     4     4     4     4     4
     E     5     5     5     5     4     5     5     5     5     5
     F     0     0     0     0     0     5     0     0     0     0
     G     5     5     5     5     5     5     6     5     5     5
     H     0     0     0     0     0     6     6     7     0     0
     I     7     9     9     9     9     7     7     7     8     9
     J     1     1     1     1     1     1     1     1     1     9
```     
     
Print all the shortest paths and distances between two arbitrary stations: 
```
A -> A   Distance: 0   Path: A -> A
A -> B   Distance: 12   Path: A -> B
A -> C   Distance: 17   Path: A -> B -> C
A -> D   Distance: 19   Path: A -> D
A -> E   Distance: 20   Path: A -> E
A -> F   Distance: 25   Path: A -> E -> F
A -> G   Distance: 16   Path: A -> G
A -> H   Distance: 48   Path: A -> B -> I -> H
A -> I   Distance: 27   Path: A -> B -> I
A -> J   Distance: 37   Path: A -> B -> I -> J

B -> A   Distance: 27   Path: B -> C -> D -> E -> F -> A
B -> B   Distance: 0   Path: B -> B
B -> C   Distance: 5   Path: B -> C
B -> D   Distance: 10   Path: B -> C -> D
B -> E   Distance: 17   Path: B -> C -> D -> E
B -> F   Distance: 22   Path: B -> C -> D -> E -> F
B -> G   Distance: 42   Path: B -> I -> H -> G
B -> H   Distance: 36   Path: B -> I -> H
B -> I   Distance: 15   Path: B -> I
B -> J   Distance: 25   Path: B -> I -> J

C -> A   Distance: 22   Path: C -> D -> E -> F -> A
C -> B   Distance: 34   Path: C -> D -> E -> F -> A -> B
C -> C   Distance: 0   Path: C -> C
C -> D   Distance: 5   Path: C -> D
C -> E   Distance: 12   Path: C -> D -> E
C -> F   Distance: 17   Path: C -> D -> E -> F
C -> G   Distance: 38   Path: C -> D -> E -> F -> A -> G
C -> H   Distance: 70   Path: C -> D -> E -> F -> A -> B -> I -> H
C -> I   Distance: 49   Path: C -> D -> E -> F -> A -> B -> I
C -> J   Distance: 59   Path: C -> D -> E -> F -> A -> B -> I -> J

D -> A   Distance: 17   Path: D -> E -> F -> A
D -> B   Distance: 29   Path: D -> E -> F -> A -> B
D -> C   Distance: 34   Path: D -> E -> F -> A -> B -> C
D -> D   Distance: 0   Path: D -> D
D -> E   Distance: 7   Path: D -> E
D -> F   Distance: 12   Path: D -> E -> F
D -> G   Distance: 33   Path: D -> E -> F -> A -> G
D -> H   Distance: 65   Path: D -> E -> F -> A -> B -> I -> H
D -> I   Distance: 44   Path: D -> E -> F -> A -> B -> I
D -> J   Distance: 54   Path: D -> E -> F -> A -> B -> I -> J

E -> A   Distance: 10   Path: E -> F -> A
E -> B   Distance: 22   Path: E -> F -> A -> B
E -> C   Distance: 27   Path: E -> F -> A -> B -> C
E -> D   Distance: 29   Path: E -> F -> A -> D
E -> E   Distance: 0   Path: E -> E
E -> F   Distance: 5   Path: E -> F
E -> G   Distance: 26   Path: E -> F -> A -> G
E -> H   Distance: 58   Path: E -> F -> A -> B -> I -> H
E -> I   Distance: 37   Path: E -> F -> A -> B -> I
E -> J   Distance: 47   Path: E -> F -> A -> B -> I -> J

F -> A   Distance: 5   Path: F -> A
F -> B   Distance: 17   Path: F -> A -> B
F -> C   Distance: 22   Path: F -> A -> B -> C
F -> D   Distance: 24   Path: F -> A -> D
F -> E   Distance: 25   Path: F -> A -> E
F -> F   Distance: 0   Path: F -> F
F -> G   Distance: 21   Path: F -> A -> G
F -> H   Distance: 53   Path: F -> A -> B -> I -> H
F -> I   Distance: 32   Path: F -> A -> B -> I
F -> J   Distance: 42   Path: F -> A -> B -> I -> J

G -> A   Distance: 16   Path: G -> F -> A
G -> B   Distance: 28   Path: G -> F -> A -> B
G -> C   Distance: 33   Path: G -> F -> A -> B -> C
G -> D   Distance: 35   Path: G -> F -> A -> D
G -> E   Distance: 36   Path: G -> F -> A -> E
G -> F   Distance: 11   Path: G -> F
G -> G   Distance: 0   Path: G -> G
G -> H   Distance: 64   Path: G -> F -> A -> B -> I -> H
G -> I   Distance: 43   Path: G -> F -> A -> B -> I
G -> J   Distance: 53   Path: G -> F -> A -> B -> I -> J

H -> A   Distance: 4   Path: H -> A
H -> B   Distance: 16   Path: H -> A -> B
H -> C   Distance: 21   Path: H -> A -> B -> C
H -> D   Distance: 23   Path: H -> A -> D
H -> E   Distance: 24   Path: H -> A -> E
H -> F   Distance: 17   Path: H -> G -> F
H -> G   Distance: 6   Path: H -> G
H -> H   Distance: 0   Path: H -> H
H -> I   Distance: 31   Path: H -> A -> B -> I
H -> J   Distance: 41   Path: H -> A -> B -> I -> J

I -> A   Distance: 25   Path: I -> H -> A
I -> B   Distance: 17   Path: I -> J -> B
I -> C   Distance: 22   Path: I -> J -> B -> C
I -> D   Distance: 27   Path: I -> J -> B -> C -> D
I -> E   Distance: 34   Path: I -> J -> B -> C -> D -> E
I -> F   Distance: 38   Path: I -> H -> G -> F
I -> G   Distance: 27   Path: I -> H -> G
I -> H   Distance: 21   Path: I -> H
I -> I   Distance: 0   Path: I -> I
I -> J   Distance: 10   Path: I -> J

J -> A   Distance: 34   Path: J -> B -> C -> D -> E -> F -> A
J -> B   Distance: 7   Path: J -> B
J -> C   Distance: 12   Path: J -> B -> C
J -> D   Distance: 17   Path: J -> B -> C -> D
J -> E   Distance: 24   Path: J -> B -> C -> D -> E
J -> F   Distance: 29   Path: J -> B -> C -> D -> E -> F
J -> G   Distance: 49   Path: J -> B -> I -> H -> G
J -> H   Distance: 43   Path: J -> B -> I -> H
J -> I   Distance: 22   Path: J -> B -> I
J -> J   Distance: 0   Path: J -> J
```
     
3)input the name of the start and end station: (such as: "J->G")
```
Input: J->I
J -> I   Distance: 22   Path: J -> B -> I
```

