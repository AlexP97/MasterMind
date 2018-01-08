JFLAGS = -g
JC = javac src/domain/*.java src/persistence/*.java src/presentation/*.java src/utils/*.java -cp test/lib/junit-4.12.jar
JVM= java

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java
	

CLASSES = \
	src/MasterMind.java \
	src/Main.java \
	src/domain/Casilla.java \
	src/domain/CodeBreaker.java \
	src/domain/CodeMaker.java \
	src/domain/CodePeg.java \
	src/domain/Game.java \
	src/domain/Jugador.java \
	src/domain/KeyPeg.java \
	src/domain/Ranking.java \
	src/domain/CtrlDominio.java \
	src/domain/CtrlDominioJugador.java \
	src/domain/CtrlDominioPartida.java \
	src/domain/CtrlDominioRanking.java \
	src/utils/Funciones.java \
	src/utils/Pair.java \
	src/persistence/GamePersistencia.java \
	src/persistence/JugadorPersistencia.java \
	src/persistence/CtrlPersistencia.java \
	src/persistence/CtrlPersistenciaGame.java \
	src/persistence/CtrlPersistenciaJugador.java \
	src/persistence/CtrlPersistenciaRanking.java \
	src/presentation/CtrlPresentacion.java \
	src/presentation/CtrlPresentacionGame.java \
	src/presentation/CtrlPresentacionLoginRegister.java \
	src/presentation/CtrlPresentacionModificarDatos.java \
	src/presentation/CtrlPresentacionRanking.java \
	src/presentation/VistaCargarPart.java \
	src/presentation/VistaCodigoInicial.java \
	src/presentation/VistaInfo.java \
	src/presentation/VistaInfoCodebreaker.java \
	src/presentation/VistaInfoCodemaker.java \
	src/presentation/VistaLogin.java \
	src/presentation/VistaMenuPartida.java \
	src/presentation/VistaModificar.java \
	src/presentation/VistaNuevaPart.java \
	src/presentation/VistaPresentacion.java \
	src/presentation/VistaRanking.java \
	src/presentation/VistaRegister.java \
	src/presentation/VistaTableroCodeB.java \
	src/presentation/VistaTableroCodeM.java 

MAIN = Main
MAINOLD = MasterMind
CLASSPATH = build

default: classes

classes: $(CLASSES:.java=.class)

run: src/Main.java
	$(JVM) -cp ./src/:.src/presentation/:.src/resources/ $(MAIN)

run_old: src/MasterMind.class 
	$(JVM) -cp ./src/ $(MAINOLD)

clean:
	$(RM) src/domain/*.class
	$(RM) src/persistence/*.class
	$(RM) src/utils/*.class
	$(RM) src/presentation/*.class
