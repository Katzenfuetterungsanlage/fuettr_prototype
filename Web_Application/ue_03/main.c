#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MAXDIM 10

int gibGanzeZahlEin(char* text, int ug, int og)
{
  int zahl;
  char s[80];
  do
  {
    printf("%s: ", text);
    fgets(s, 80, stdin);
    fflush(stdin);
  }
  while (sscanf(s, "%d", &zahl) < 0 || zahl < ug || zahl > og);
  return zahl;
}

int zeilenSumme(int q[][MAXDIM], int dim, int index)
{
  int summe = 0, sp;
  for (sp = 0; sp < dim; sp++)
    summe += q[index][sp];
  return summe;
}

int spaltenSumme(int q[][MAXDIM], int dim, int index)
{
  int summe = 0, ze;
  for (ze = 0; ze < dim; ze++)
    summe += q[ze][index];
  return summe;
}

int diagonalSumme(int q[][MAXDIM], int dim, int index)
{
  int summe = 0, ze;
  for (ze = 0; ze < dim; ze++)
    summe += q[ze][(index) ? dim - 1 - ze : ze];
  return summe;
}

int pruefeZahlen(int q[][MAXDIM], int dim)
{
  int i, ze, sp, z[MAXDIM * MAXDIM + 1];

  for (i = 1; i <= dim * dim; i++)
    z[i] = 0;
  for (ze = 0; ze < dim; ze++)
    for (sp = 0; sp < dim; sp++)
    {
      int inhalt = q[ze][sp];
      if (inhalt < 1 || inhalt > dim * dim || ++z[inhalt] > 1)
        return 0;
    }
  return 1;
}

int istMagischesQuadrat(int q[][MAXDIM], int dim)
{
  int referenz = zeilenSumme(q, dim, 0), i;
  for (i = 1; i < dim; i++)
    if (referenz != zeilenSumme(q, dim, i))
      return 0;

  for (i = 0; i < dim; i++)
    if (referenz != spaltenSumme(q, dim, i))
      return 0;

  for (i = 0; i < 2; i++)
    if (referenz != diagonalSumme(q, dim, i))
      return 0;

  return pruefeZahlen(q, dim);
}

int gibQuadratEin(int q[][MAXDIM])
{
  int ze, sp, dim = gibGanzeZahlEin("Dimension: ", 1, MAXDIM);
  for (ze = 0; ze < dim; ze++)
    for (sp = 0; sp < dim; sp++)
    {
      char s[80];
      sprintf(s, "Zeile %d / Spalte %d", ze + 1, sp + 1);
      q[ze][sp] = gibGanzeZahlEin(s, 1, dim * dim);
    }
  return dim;
}

void gibQuadratAus(int q[][MAXDIM], int dim)
{
  int ze, sp, i;
  for (i = 0; i < dim * 4 + 1; i++)
    printf(" ");
  printf("|%4d\n", diagonalSumme(q, dim, 1));
  for (i = 0; i < dim; i++)
    printf("----");
  printf("-+-----\n");
  for (ze = 0; ze < dim; ze++)
  {
    for (sp = 0; sp < dim; sp++)
      printf("%4d", q[ze][sp]);
    printf(" |%4d\n", zeilenSumme(q, dim, ze));
  }
  for (i = 0; i < dim; i++)
    printf("----");
  printf("-+-----\n");
  for (sp = 0; sp < dim; sp++)
    printf("%4d", spaltenSumme(q, dim, sp));
  printf(" |%4d\n\n", diagonalSumme(q, dim, 0));

  if (istMagischesQuadrat(q, dim))
    printf("Dies ist ein Magisches Quadrat!\n\n");
  else
    printf("Dies ist kein Magisches Quadrat!\n\n");
}

void finde3x3Quadrat()
{
  int q[MAXDIM][MAXDIM], q00, q01, q02, q10, q11, q12, q20, q21, q22, anz = 0;
  for (q00 = 1; q00 <= 9; q00++)
  {
    q[0][0] = q00;
    for (q01 = 1; q01 <= 9; q01++)
      if (q01 != q00)
      {
        q[0][1] = q01;
        for (q02 = 1; q02 <= 9; q02++)
          if (q02 != q00 && q02 != q01)
          {
            q[0][2] = q02;
            for (q10 = 1; q10 <= 9; q10++)
              if (q10 != q00 && q10 != q01 && q10 != q02)
              {
                q[1][0] = q10;
                for (q11 = 1; q11 <= 9; q11++)
                  if (q11 != q00 && q11 != q01 && q11 != q02 && q11 != q10)
                  {
                    q[1][1] = q11;
                    for (q12 = 1; q12 <= 9; q12++)
                      if (q12 != q00 && q12 != q01 && q12 != q02 && q12 != q10 && q12 != q11)
                      {
                        q[1][2] = q12;
                        for (q20 = 1; q20 <= 9; q20++)
                          if (q20 != q00 && q20 != q01 && q20 != q02 && q20 != q10 && q20 != q11 && q20 != q12)
                          {
                            q[2][0] = q20;
                            for (q21 = 1; q21 <= 9; q21++)
                              if (q21 != q00 && q21 != q01 && q21 != q02 && q21 != q10 && q21 != q11 && q21 != q12 && q21 != q20)
                              {
                                q[2][1] = q21;
                                for (q22 = 1; q22 <= 9; q22++)
                                  if (q22 != q00 && q22 != q01 && q22 != q02 && q22 != q10 && q22 != q11 && q22 != q12 && q22 != q20 && q22 != q21)
                                  {
                                    q[2][2] = q22;
                                    if (istMagischesQuadrat(q, 3))
                                    {
                                      gibQuadratAus(q, 3);
                                      anz++;
                                    }
                                  }
                              }
                          }
                      }
                  }
              }
          }
      }
  }
  printf("\n%d magische Quadrate gefunden!\n", anz);
}

void finde4x4Quadrate()
{
  int q[MAXDIM][MAXDIM], q00, q01, q02, q03, q10, q11, q12, q13, q20, q21, q22, q23, anz = 0;
  for (q00 = 1; q00 <= 16; q00++)
  {
    q[0][0] = q00;
    for (q01 = 1; q01 <= 16; q01++)
      if (q01 != q00)
      {
        q[0][1] = q01;
      }
  }
}

void delay(int time)
{
   int c = 1, d = 1;
 
   for ( c = 1 ; c <= time ; c++ )
       for ( d = 1 ; d <= time ; d++ )
       {}
 
   return 0;
}

int main(int argc, char** argv)
{
  int wahl;
  char s[80];
  do
  {
    
    printf(
            "Magische Quadrate\n\n"
            "Quadrat pruefen .............................1\n"
            "Finde magische 3x3 Quadrate .................2\n"
            "Finde magische 4x4 Quadrate .................3\n"
            "Oesterreich-Ungarn for life..................4\n\n"
            "Programmende ................................9\n\n"
            );
    wahl = gibGanzeZahlEin("Ihre Wahl: ", 1, 9);
    
    switch (wahl)
    {
      case 1:
      {
        int q[MAXDIM][MAXDIM], dim = gibQuadratEin(q);
        printf("\n\n");
        gibQuadratAus(q, dim);
      }
        break;

      case 2:
      {
        unsigned vorher = clock(), nachher;
        finde3x3Quadrat();
        nachher = clock();
        printf("\n%.3lf Sekunden Berechnungszeit (%.9lf Sekunden Genauigkeit)\n", ((double) (nachher - vorher)) / CLOCKS_PER_SEC, 1.0 / CLOCKS_PER_SEC);
      }
        break;

      case 4:
      {
        delay(20000);
        printf("\n\n 00  000 0   0 00    0   0 0  0 00  000  00\n");
        delay(20000);
        printf("0  0 0   0   0 0 0   0   0 0  0 0 0 0   0  0\n");
        delay(20000);
        printf("0    0   00  0 0 0   00  0 0  0 0 0 0   0\n");
        delay(20000);
        printf(" 00  000 0 0 0 0 0   0 0 0 0  0 0 0 000  00\n");
        delay(20000);
        printf("   0 0   0  00 0 0   0  00 0  0 0 0 0      0\n");
        delay(20000);
        printf("0  0 0   0   0 0 0   0   0 0  0 0 0 0   0  0\n");
        delay(20000);
        printf(" 00  000 0   0 00    0   0  00  00  000  00\n\n");
      }
    }
    if (wahl != 9)
    {
      printf("\nBitte [Enter] druecken!\n\n");
      fgets(s, 4, stdin);
      
    }
  }
  while (wahl != 9);

  /*
    int q[MAXDIM][MAXDIM], dim = gibQuadratEin(q);
    printf("\n\n");
    gibQuadratAus(q, dim);
   */

  return (EXIT_SUCCESS);
}

/*
Eingabe:
Dimension: 2
Zeile 1 / Spalte 1: 1
Zeile 1 / Spalte 2: 2
Zeile 2 / Spalte 1: 3
Zeile 2 / Spalte 2: 4
 */

/*
 Ausgabe:
        5
 1  2 | 3
 3  4 | 7
 -----+--
 4  6 | 5
 */
