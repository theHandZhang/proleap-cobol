 IDENTIFICATION DIVISION.
 PROGRAM-ID. RELEMPTY.
 DATA DIVISION.
 WORKING-STORAGE SECTION.
 01 SOMEGROUP.
    05 SOMETEXT PIC X(20).
 PROCEDURE DIVISION.
    IF SOMEGROUP = SPACE
       DISPLAY 'test'
    END-IF.