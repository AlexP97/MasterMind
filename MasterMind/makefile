JFLAGS = -g -Xlint
JC = javac src/domain/*.java src/persistence/*.java src/utils/*.java test/domain/*.java test/persistence/*.java test/utils/*.java -classpath test/*.jar -d $(CLASSPATH)
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
        test/domain/CodeBreakerDriver.java \
        test/domain/CodeMakerDriver.java \
        test/domain/CodePegDriver.java \
	test/domain/CodePegStub.java \
	test/domain/GameTest.java \
	test/domain/JugadorDriver.java \
	test/domain/JugadorStub.java \
	test/domain/KeyPegDriver.java \
	test/domain/KeyPegStub.java \
	test/domain/RankingDriver.java \
	test/domain/RankingStub.java \
	test/utils/FuncionesDriver.java \
	test/utils/PairDriver.java \
	test/domain/Tests.java

MAIN = domain.MasterMind
MAINTEST = domain.Tests
CLASSPATH = build

default: classes

classes: $(CLASSES:.java=.class)

run: build/domain/MasterMind.class 
	$(JVM) -cp ./$(CLASSPATH) $(MAIN)

run_tests: build/domain/Tests.class 
	$(JVM) -cp ./$(CLASSPATH) $(MAINTEST)

clean:
	$(RM) $(CLASSPATH)/domain/*.class
	$(RM) $(CLASSPATH)/persistence/*.class
	$(RM) $(CLASSPATH)/utils/*.class
