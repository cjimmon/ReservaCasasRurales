@echo off
REM Ejecuta el JAR con la JRE incluida
"%~dp0jre\bin\javaw.exe" -jar "%~dp0casas-1.0-SNAPSHOT-shaded.jar"
exit
