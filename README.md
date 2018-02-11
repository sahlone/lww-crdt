# java-crdt

Collection of LWW CRDTs for Java.

### CRDT Sets

- LWW-Set: Last-Write-Wins-Element Set. Uses 'timestamps' associated with addition and deletion operations for picking the winner.

### Build

- To build the project we need maven 

- `$ mvn compile`
- `$ mvn package`

 We can use th jar produced to run use it as a library ie `lww-crdt-1.0-SNAPSHOT.jar`
 
### Tests

- `$ mvn tests`