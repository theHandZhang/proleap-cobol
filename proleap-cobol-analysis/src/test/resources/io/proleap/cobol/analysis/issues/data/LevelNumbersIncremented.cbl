  IDENTIFICATION DIVISION.
 PROGRAM-ID. LVL.
 DATA DIVISION.
 WORKING-STORAGE SECTION.
 01  COUNTER1.
 	05  COUNTER11 PIC 9(8).
 	 10  COUNTER111 PIC 9(8).
 	 10  COUNTER112 PIC 9(8).
 
 01  COUNTER2.
 	05  COUNTER21 PIC 9(8).
 	05  COUNTER22 PIC 9(8).
 	05  COUNTER23 PIC 9(8).
 	05  COUNTER24.
 		06  COUNTER241 PIC 9(8).
 		06  COUNTER242 PIC 9(8).
 		06  COUNTER243 PIC 9(8).
 		
 01  COUNTER3 PIC 9(8).
 
 01  COUNTER4 PIC 9(8).
 	02 COUNTER41 PIC 9.
 		03 COUNTER411 PIC9.
 
 01  COUNTER5 PIC 9(8).
 	10  COUNTER51 PIC 9(8).
 
 LINKAGE SECTION.

 PROCEDURE DIVISION.
