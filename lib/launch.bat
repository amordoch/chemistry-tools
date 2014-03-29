@ECHO OFF
color 8f
java -jar chem-tools-v0.6.5-alpha.jar
@echo:
@echo Program will now quit. Please wait...
ping 192.0.2.1 -n 1 -w 10000 >nul