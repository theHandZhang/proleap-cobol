 IDENTIFICATION DIVISION.
 PROGRAM-ID.  PerformTimes.
 DATA DIVISION.
 WORKING-STORAGE SECTION.
 01 TimesNum PIC 9 VALUE 3.

 PROCEDURE DIVISION.
 Begin.
    DISPLAY "Starting program"
    PERFORM 3 TIMES
       DISPLAY "Inline perform"
    END-PERFORM
    DISPLAY "Stopping program".
    STOP RUN.