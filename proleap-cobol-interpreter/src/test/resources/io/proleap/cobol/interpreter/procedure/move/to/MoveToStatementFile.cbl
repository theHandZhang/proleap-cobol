 IDENTIFICATION DIVISION.
 PROGRAM-ID. MOVETOSTMT.
 ENVIRONMENT DIVISION.
    INPUT-OUTPUT SECTION.
       FILE-CONTROL.
          SELECT RL-FS2.
 DATA DIVISION.
    FILE SECTION.
       FD RL-FS2.
          01 SOMEFILE1-100.
             02 FILLER PIC X(100).
    WORKING-STORAGE SECTION.
       01 FILE-RECORD-INFORMATION-REC.
          03 FILE-RECORD-INFO OCCURS 10 TIMES.
             05 FILE-RECORD-INFO-P1-100.
                07 XFILE-NAME PIC X(10).
                07 FILLER PIC X(90).
 PROCEDURE DIVISION.
     MOVE SOMEFILE1-100 TO FILE-RECORD-INFO-P1-100 (1).