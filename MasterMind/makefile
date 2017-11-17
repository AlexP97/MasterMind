JFLAGS = -g
JC = javac src/domain/*.java src/persistence/*.java src/utils/*.java test/domain/*.java test/persistence/*.java test/utils/*.java -cp test/lib/junit-4.12.jar
JVM= java

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java
	

CLASSES = \
        src/domain/MasterMind.java \
        src/domain/Casilla.java \
        src/domain/CodeBreaker.java \
        src/domain/CodeMaker.java \
        src/domain/CodePeg.java \
	src/domain/Game.java \
	src/domain/Jugador.java \
	src/domain/KeyPeg.java \
	src/domain/Ranking.java \
	src/utils/Funciones.java \
	src/utils/Pair.java \
	src/persistence/GamePersistencia.java \
	src/persistence/JugadorPersistencia.java \
	src/persistence/RankingPersistencia.java \
	test/persistence/GamePersistenciaDriver.java \
	test/persistence/JugadorPersistenciaDriver.java \
	test/persistence/RankingPersistenciaDriver.java \
        test/domain/CodeBreakerDriver.java \
        test/domain/CodeMakerDriver.java \
        test/domain/CodePegDriver.java \
	test/domain/CodePegStub.java \
	test/domain/JugadorDriver.java \
	test/domain/JugadorStub.java \
	test/domain/KeyPegDriver.java \
	test/domain/KeyPegStub.java \
	test/domain/RankingDriver.java \
	test/domain/RankingStub.java \
	test/utils/FuncionesDriver.java \
	test/utils/PairDriver.java \
	test/Tests.java

MAIN = domain.MasterMind
MAINTEST = Tests
CLASSPATH = build

default: classes

classes: $(CLASSES:.java=.class)

run: src/domain/MasterMind.class 
	$(JVM) -cp ./src/ $(MAIN)

run_tests: test/Tests.class 
	$(JVM) -cp ./test/ $(MAINTEST)
	
run_junit: test/domain/GameTest.class
	java -cp ./test/lib/junit-4.12.jar:./test/lib/hamcrest-1.10.jar:./test/:./src/ org.junit.runner.JUnitCore domain.GameTest


clean:
	$(RM) src/domain/*.class
	$(RM) src/persistence/*.class
	$(RM) src/utils/*.class
	$(RM) test/domain/*.class
	$(RM) test/persistence/*.class
	$(RM) test/utils/*.class
	$(RM) test/*.class
