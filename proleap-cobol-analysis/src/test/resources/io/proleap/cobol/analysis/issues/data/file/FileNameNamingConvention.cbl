 IDENTIFICATION DIVISION.
 PROGRAM-ID. READSTMT.
 ENVIRONMENT DIVISION.
    INPUT-OUTPUT SECTION.
       FILE-CONTROL.
          SELECT SOMEFILE1 ASSIGN TO 'somefile1.txt'.
          SELECT SOMEFILE2 ASSIGN TO 'Test'.
          SELECT SOMEFILE3 ASSIGN TO '!'.
          SELECT SOMEFILE4 ASSIGN TO '&#xBB;&#xA3;???&#xAB;#'.
          SELECT SOMEFILE5 ASSIGN TO '\n'.
          SELECT SOMEFILE6 ASSIGN TO 'some file.txt'.
          SELECT SOMEFILE7 ASSIGN TO ''.
          SELECT SOMEFILE8 ASSIGN TO SOME_IDENTIFIER.
          SELECT SOMEFILE9 ASSIGN TO FC-I1.
          SELECT SOMEFILE10 ASSIGN TO FC_S1.