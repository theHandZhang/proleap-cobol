 IDENTIFICATION DIVISION.
 PROGRAM-ID. LGTH.
 DATA DIVISION.
 WORKING-STORAGE SECTION.
 01 SOMEGROUP.
    05 SOMETEXT PIC X(20).
 01 SOMELENGTH PIC 9(10).
 PROCEDURE DIVISION.
    MOVE LENGTH OF SOMEGROUP TO SOMELENGTH.