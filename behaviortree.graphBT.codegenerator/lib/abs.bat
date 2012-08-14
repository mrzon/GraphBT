@echo off
REM - LABEL INDICATING THE BEGINNING OF THE DOCUMENT.
:BEGIN

REM - THE BELOW LINE GIVES THE USER 5 CHOICES (DEFINED AFTER /C:)

REM - THE NEXT THREE LINES ARE DIRECTING USER DEPENDING UPON INPUT
IF %1 ==check GOTO THREE
IF %1 ==code GOTO TWO
IF %1 ==execute GOTO ONE
IF %1 ==compile GOTO FOUR
IF %1 ==toabs GOTO FIVE
GOTO END
:THREE
REM %check model "abs.bat check file.abs"
ECHO Checking...
java -Xms64m -Xmx256m -jar absfrontend.jar %2
GOTO END
:TWO
ECHO Generating Code...
REM %generate java code "abs.bat code file.abs \java\gen"
java -Xms64m -Xmx256m -cp absfrontend.jar abs.backend.java.JavaBackend -d %3 %2
GOTO END
:ONE
ECHO Executing...
REM %executing generated code "abs.bat execute java\gen Test"
java -cp %2;absfrontend.jar %3.Main
GOTO END
:FOUR
REM %compiling java file "abs.bat compile \java\gen Test Hello_fli.java"
echo Compiling..
javac -cp %2;absfrontend.jar %2\%3\%4
:FIVE
echo Generating ABS code..
java -jar BT2ABS.jar %2 %3 %4
GOTO END
:END







