# Examen Base de Datos - Utilizar BD PostgreSQL (local).
## LOS GRANDES ALMACENES
<img width="1136" alt="Captura de Pantalla 2022-04-13 a la(s) 4 17 50 p m" src="https://user-images.githubusercontent.com/56992179/163272085-2f96853b-4d4e-4906-a6b2-13b907bbbeb0.png">

**En base al ER generar los Querys necesarios para solventarlos**:

1. Generar script para poblar todas las tablas.
>#
2. Mostrar el número de ventas de cada producto, ordenado de más a menos ventas.

```
SELECT tp.producto, COUNT(1) AS total
FROM venta tp
GROUP BY tp.producto
HAVING COUNT(1) >= 1
ORDER BY total desc;
```

<img width="1136" alt="Captura de Pantalla 2022-04-14 a la(s) 3 41 18 a m" src="https://user-images.githubusercontent.com/56992179/163348014-1aa55c63-324b-4732-b09c-a5159f553870.png">

3. Obtener un informe completo de ventas, indicando el nombre del cajero que realizo la venta, nombre y precios de los productos vendidos, y el piso en el que se encuentra la máquina registradora donde se realizó la venta.

```
-- Usando INNER JOIN
SELECT ven.cajero as cajero, caj."NomApels" as nombre_cajero, pro.nombre as nombre_producto, pro.precio as precio, maq.piso as piso FROM venta ven 
INNER JOIN cajeros caj ON (caj.cajero = ven.cajero)
INNER JOIN productos pro ON (pro.producto = ven.producto)
INNER JOIN maquinas_registradoras maq ON (maq.maquina = ven.maquina)
GROUP BY  ven.cajero, caj."NomApels", pro.nombre, pro.precio, maq.piso; 
ORDER BY cajero desc;

-- USANDO WHERE
SELECT "NomApels", nombre, precio, piso
FROM venta V, cajeros C, productos P, maquinas_registradoras M
WHERE V.cajero = C.cajero
AND V.producto = P.producto
AND V.maquina = M.maquina
ORDER BY V.cajero desc;
```

<img width="1136" alt="Captura de Pantalla 2022-04-14 a la(s) 3 39 55 a m" src="https://user-images.githubusercontent.com/56992179/163347803-0410b291-b613-471d-921c-5431c9ab9997.png">

<img width="1136" alt="Captura de Pantalla 2022-04-14 a la(s) 3 40 10 a m" src="https://user-images.githubusercontent.com/56992179/163347823-60a19f02-2638-42a9-abb5-fd7d2456329f.png">

4. Obtener las ventas totales realizadas en cada piso.

```
-- En conteo
SELECT maq.piso as piso, COUNT(maq.piso) AS ventas FROM venta ven
INNER JOIN maquinas_registradoras maq ON (maq.maquina = ven.maquina)
GROUP BY maq.piso
ORDER BY ventas desc;

-- En suma
SELECT piso, SUM(precio)
FROM venta V, productos P, maquinas_registradoras M
WHERE V.producto = P.producto
AND V.maquina = M.maquina
GROUP BY piso
ORDER BY SUM(precio) desc;
```

<img width="1136" alt="Captura de Pantalla 2022-04-14 a la(s) 3 38 04 a m" src="https://user-images.githubusercontent.com/56992179/163347482-ba47a4f0-af22-4342-9b24-76e580939d06.png">

<img width="1136" alt="Captura de Pantalla 2022-04-14 a la(s) 3 38 16 a m" src="https://user-images.githubusercontent.com/56992179/163347493-96e7eb79-10c4-49db-a31a-7198160ae9c2.png">

5. Obtener el código y nombre de cada cajero junto con el importe total de sus ventas.

```
SELECT ven.cajero as cajero, caj."NomApels" as nombre_cajero, SUM(pro.precio) as importe FROM venta ven 
INNER JOIN cajeros caj ON (caj.cajero = ven.cajero)
INNER JOIN productos pro ON (pro.producto = ven.producto)
GROUP BY  ven.cajero, caj."NomApels"
ORDER BY importe desc;
```

<img width="1136" alt="Captura de Pantalla 2022-04-14 a la(s) 3 36 25 a m" src="https://user-images.githubusercontent.com/56992179/163347186-9bfca0cd-ca28-4170-a721-ba47777c84e4.png">

6. Obtener el código y nombre de aquellos cajeros que hayan realizado ventas en pisos cuyas ventas totales sean inferiores a los 5000 pesos.

```
SELECT *
FROM cajeros
WHERE cajero IN (
 SELECT cajero
 FROM venta
 WHERE maquina IN (
 SELECT maquina
 FROM maquinas_registradoras
 WHERE piso IN (
 SELECT piso
 FROM venta ven, productos pro, maquinas_registradoras maq
 WHERE ven.producto = pro.producto
 AND ven.maquina = maq.maquina
 GROUP BY piso
 HAVING SUM(precio) < 5000)))
```

<img width="1136" alt="Captura de Pantalla 2022-04-14 a la(s) 3 26 18 a m" src="https://user-images.githubusercontent.com/56992179/163345390-748af55d-f717-4581-8cae-14284cf80154.png">


