 IDENTIFICATION DIVISION.
 PROGRAM-ID. RELEMPTY.
 DATA DIVISION.
 WORKING-STORAGE SECTION.
 01 SOMEID PIC 9(20).
 PROCEDURE DIVISION.
    IF SOMEID = ZERO
       DISPLAY 'test'
    END-IF.