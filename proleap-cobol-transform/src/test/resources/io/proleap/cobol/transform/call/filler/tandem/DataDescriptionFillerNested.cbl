 IDENTIFICATION DIVISION.
 PROGRAM-ID. DATADESCRFILLERNESTED.
 DATA DIVISION.
 WORKING-STORAGE SECTION.
 01 FILLER.
    05 SOMEID PIC X(20) VALUE 'SOME-VALUE'.
 PROCEDURE DIVISION.
    MOVE "Test" TO SOMEID.