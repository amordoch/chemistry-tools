@ECHO OFF
color 8f
java -jar chem-tools-0.5.jar
@echo:
@echo Quitting in 10 seconds...
ping 192.0.2.1 -n 1 -w 10000 >nul