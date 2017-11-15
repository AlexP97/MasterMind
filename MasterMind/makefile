JFLAGS = -g -Xlint
JC = javac src/domain/*.java src/persistence/*.java src/utils/*.java test/domain/*.java test/persistence/*.java test/utils/*.java -classpath test/*.jar -d $(CLASSPATH)
JVM= java

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
        src/domain/*.java \
	src/persistence/*.java \
	src/utils/*.java \
        test/domain/*.java \
	test/persistence/*.java \
	test/utils/*.java

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
