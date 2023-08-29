/************************************************************************/
-- OBTENER LA CLASIFICACION GENERAL  CORRESPONDIENTE DE 2001
 SIN TENER EN CUENTA LOS EMPATES A PUNTOS.

SELECT P.NOMBRE, A.PUNTOS
FROM PAIS P,(SELECT v.codpaisvotado PAIS,SUM(v.puntuacion) PUNTOS
            FROM VOTACION V
            WHERE v.codedicion='2001'
            GROUP BY v.codpaisvotado)A
WHERE P.CODPAIS=A.PAIS 
ORDER BY A.PUNTOS DESC

/************************************************************************/

-- PAISES PARTICIPANTES EN CADA EDICION

SELECT v.codedicion,p.nombre
FROM VOTACION V, PAIS P
WHERE p.codpais=v.codpaisvotante
GROUP BY v.codedicion,p.nombre
ORDER BY v.codedicion

/***********************************************************************/
-- PAISES QUE HAN VOTADO A ESPAÑA EN ALGUNA DE LAS EDICIONES,INDICANDO LA EDICION
-- Y LOS PUNTOS QUE NOS HAN DADO

SELECT p.nombre,v.codedicion, v.puntuacion
FROM VOTACION V, PAIS P
WHERE v.codpaisvotado=(SELECT p.codpais
                        FROM PAIS P
                        WHERE P.NOMBRE='ESPAÑA')
AND v.codpaisvotante=p.codpais
ORDER BY v.codedicion,v.puntuacion DESC

/******************************************************************************/
-- EDICION, NOMBRE DEL PAIS VOTADO Y PUNTUACION
-- PARA LOS PAISES A LOS QUE ESPAÑA HA VOTADO CON PUNTUACION 12 O 10 PUNTOS
-- EN CUALQUIERA DE LAS EDICIONES.

NO ESTA BIEN

SELECT v.codedicion, p.nombre, v.puntuacion
FROM VOTACION V, PAIS P
WHERE v.codpaisvotado=p.codpais
AND v.codpaisvotante=(SELECT p.codpais
                        FROM PAIS P
                        WHERE P.NOMBRE='ESPAÑA')
AND v.puntuacion IN (10,12)

/* ************************************************************************/
-- NOMBRE DEL PAIS Y PUNTOS TOTALES A LO LARGO DE TODAS LAS EDICIONES PARA
-- AQUEL PAIS O PAISES PARA LOS QUE LA SUMA DE VOTOS QUE LE HA DADO ESPAÑA
-- A LO LARGO DE TODAS LAS EDICIONES ES MAXIMA.

NO HE ENTENDIDO EL ENUNCIADO, HE SACADO LOS PAISES QUE LE HAN DADO MAS PUNTOS A ESPAÑA
¡¡¡¡¡¡HAY QUE SACAR EL PAIS O PAISES QUE ESPAÑA LE HA DADO MAS PUNTOS!!!!!! 
SELECT P.NOMBRE,a.puntosdados
FROM PAIS P,(SELECT v.codpaisvotante PAISVOTANTE, SUM(V.PUNTUACION) PUNTOSDADOS
                FROM VOTACION V
                WHERE v.codpaisvotado=(SELECT P.CODPAIS
                                        FROM PAIS P
                                        WHERE P.NOMBRE='ESPAÑA')
                GROUP BY v.codpaisvotante)A
WHERE p.codpais=a.paisvotante
and a.puntosdados =(SELECT (MAX(SUM(V.PUNTUACION))) PUNTOSMAX
                    FROM VOTACION V
                    WHERE v.codpaisvotado=(SELECT P.CODPAIS
                                            FROM PAIS P
                                            WHERE P.NOMBRE='ESPAÑA')
                    GROUP BY v.codpaisvotante)


/* **********************************************************************/
--PAIS Y NUMERO DE PAISES QUE LO HAN VOTADO, SIENDO EL NUMERO DE PAISES QUE LO HAN VOTADO EL 
--MÁXIMO TENIENDO EN CUENTA TODAS LAS EDICIONES. 

/**********************************************************/



/********************************************************************/

-- CLASIFICACION DE LA EDICION 2001 TENIENDO EN CUENTA LOS EMPATES A PUNTOS
-- SE DESEMPATA POR MAYOR NUMERO DE DOCES,DIECES...

/**********************************************************/

SELECT P.NOMBRE, A.PUNTOS
FROM PAIS P,(SELECT v.codpaisvotado PAIS,SUM(v.puntuacion) PUNTOS
            FROM VOTACION V
            WHERE v.codedicion='2001'
            GROUP BY v.codpaisvotado)A,
            (SELECT B.PAISVOTADO pais,SUM(DOCES)doces,SUM(DIECES)dieces,SUM(OCHOS)ochos
                            FROM
                                (SELECT v.codpaisvotado PAISVOTADO, 1 DOCES, 0 DIECES, 0 OCHOS
                                FROM VOTACION V
                                WHERE v.puntuacion=12
                                AND v.codedicion=2001
                                UNION ALL
                                SELECT v.codpaisvotado, 0 DOCES, 1 DIECES, 0 OCHOS
                                FROM VOTACION V
                                WHERE v.puntuacion=10
                                AND v.codedicion=2001
                                UNION ALL
                                SELECT v.codpaisvotado, 0 DOCES, 0 DIECES, 1 OCHOS
                                FROM VOTACION V
                                WHERE v.puntuacion=8
                                AND v.codedicion=2001)B
                            GROUP BY b.paisvotado)D
WHERE P.CODPAIS=A.PAIS 
and d.pais=p.codpais
ORDER BY A.PUNTOS DESC,d.doces DESC ,d.dieces DESC,d.ochos DESC

/********************************************************************/

-- LA MISMA CONSULTA PERO TENIENDO EN CUENTA TODAS LAS EDICIONES
-- EN UNA UNICA CONSULTA

SELECT P.NOMBRE, A.PUNTOS, d.edicion, d.doces,d.dieces,d.ochos
FROM PAIS P,(SELECT v.codpaisvotado PAIS,v.codedicion EDICION,SUM(v.puntuacion) PUNTOS
            FROM VOTACION V
            GROUP BY v.codpaisvotado,v.codedicion)A,
            (SELECT B.PAISVOTADO pais,B.EDICION EDICION,SUM(DOCES)doces,SUM(DIECES)dieces,SUM(OCHOS)ochos
                            FROM
                                (SELECT v.codpaisvotado PAISVOTADO,v.codedicion EDICION , 1 DOCES, 0 DIECES, 0 OCHOS
                                FROM VOTACION V
                                WHERE v.puntuacion=12
                                UNION ALL
                                SELECT v.codpaisvotado,v.codedicion, 0 DOCES, 1 DIECES, 0 OCHOS
                                FROM VOTACION V
                                WHERE v.puntuacion=10
                                UNION ALL
                                SELECT v.codpaisvotado,v.codedicion, 0 DOCES, 0 DIECES, 1 OCHOS
                                FROM VOTACION V
                                WHERE v.puntuacion=8)B
                            GROUP BY b.edicion,b.paisvotado)D
WHERE P.CODPAIS=A.PAIS 
and d.pais=p.codpais
AND a.edicion=d.edicion
ORDER BY d.edicion,A.PUNTOS DESC,d.doces DESC,d.dieces DESC,d.ochos DESC

/*************************************************************************/
-- LISTADO DE CADA EDICION CON EL PAIS O PAISES GANADORES TENIENDO EN CUENTA
-- PARA POSIBLES DESEMPATES EL NUMERO DE DOCES,DESPUES EL DE DIECES, OCHOS ...


/* *****************************************************ALTERNATIVA CON ROWNUM **************************************************************/
 
/* *********             ALTERNATIVA CON RANK()                          ***************************/

SELECT P.NOMBRE, A.PUNTOS, d.edicion, d.doces,d.dieces,d.ochos
FROM PAIS P,(SELECT v.codpaisvotado PAIS,v.codedicion EDICION,SUM(v.puntuacion) PUNTOS
            FROM VOTACION V
            GROUP BY v.codpaisvotado,v.codedicion)A,
            (SELECT B.PAISVOTADO pais,B.EDICION EDICION,SUM(DOCES)doces,SUM(DIECES)dieces,SUM(OCHOS)ochos
                            FROM
                                (SELECT v.codpaisvotado PAISVOTADO,v.codedicion EDICION , 1 DOCES, 0 DIECES, 0 OCHOS
                                FROM VOTACION V
                                WHERE v.puntuacion=12
                                UNION ALL
                                SELECT v.codpaisvotado,v.codedicion, 0 DOCES, 1 DIECES, 0 OCHOS
                                FROM VOTACION V
                                WHERE v.puntuacion=10
                                UNION ALL
                                SELECT v.codpaisvotado,v.codedicion, 0 DOCES, 0 DIECES, 1 OCHOS
                                FROM VOTACION V
                                WHERE v.puntuacion=8)B
                            GROUP BY b.edicion,b.paisvotado)D
WHERE P.CODPAIS=A.PAIS 
and d.pais=p.codpais
AND a.edicion=d.edicion
ORDER BY d.edicion,A.PUNTOS DESC,d.doces DESC,d.dieces DESC,d.ochos DESC


SELECT NOMBRE,EDICION,PUNTOS,DOCES,DIECES,OCHOS
FROM(SELECT NOMBRE , PUNTOS,EDICION,DOCES,DIECES,OCHOS,RANK() OVER (PARTITION BY EDICION ORDER BY PUNTOS DESC,DOCES DESC, DIECES DESC, OCHOS DESC)POSICION
FROM v_clasificacion)
WHERE POSICION=1;
/**************************************************************************************/
/* PODEMOS CONSTRUIR UNA  VISTA CON ESTA ULTIMA SENTENCIA Y USAR ESTA VISTA PARA      */
/* SACAR EN EL LISTADO DE GANADORES TAMBIEN EL CANTANTE Y LA CANCION QUE CANTO        */
/* MI VISTA SE LLAMA: V_GANADORESEDICION                                              */
/*************************************************************************************/

         





