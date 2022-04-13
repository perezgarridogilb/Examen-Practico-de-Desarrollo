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

<img width="1136" alt="Captura de Pantalla 2022-04-13 a la(s) 1 55 17 p m" src="https://user-images.githubusercontent.com/56992179/163272212-e6e744e0-bd6d-4a5b-8cfe-7a55480442ea.png">

3. Obtener un informe completo de ventas, indicando el nombre del cajero que realizo la venta, nombre y precios de los productos vendidos, y el piso en el que se encuentra la máquina registradora donde se realizó la venta.

```
SELECT ven.cajero as cajero, caj."NomApels" as nombre_cajero, pro.nombre as nombre_producto, pro.precio as precio, maq.piso as piso FROM venta ven 
INNER JOIN cajeros caj ON (caj.cajero = ven.cajero)
INNER JOIN productos pro ON (pro.producto = ven.producto)
INNER JOIN maquinas_registradoras maq ON (maq.maquina = ven.maquina)
GROUP BY  ven.cajero, caj."NomApels", pro.nombre, pro.precio, maq.piso; 
```

<img width="1136" alt="Captura de Pantalla 2022-04-13 a la(s) 2 59 12 p m" src="https://user-images.githubusercontent.com/56992179/163272406-84e2c764-11bd-4a75-8e8c-62f85c0c915f.png">

4. Obtener las ventas totales realizadas en cada piso.

```
SELECT maq.piso as piso, COUNT(maq.piso) AS ventas FROM venta ven
INNER JOIN maquinas_registradoras maq ON (maq.maquina = ven.maquina)
GROUP BY maq.piso
ORDER BY ventas desc;
```

<img width="1136" alt="Captura de Pantalla 2022-04-13 a la(s) 4 21 24 p m" src="https://user-images.githubusercontent.com/56992179/163272638-486cd895-a49a-4ce9-a0ed-d2f7f3e61c8b.png">

5. Obtener el código y nombre de cada cajero junto con el importe total de sus ventas.

```
SELECT ven.cajero as cajero, caj."NomApels" as nombre_cajero, SUM(pro.precio) as importe FROM venta ven 
INNER JOIN cajeros caj ON (caj.cajero = ven.cajero)
INNER JOIN productos pro ON (pro.producto = ven.producto)
GROUP BY  ven.cajero, caj."NomApels"
ORDER BY importe desc;
```

<img width="1136" alt="Captura de Pantalla 2022-04-13 a la(s) 4 43 56 p m" src="https://user-images.githubusercontent.com/56992179/163275496-9ab177f8-3de5-45c0-bab4-bd7d6720a143.png">

6. Obtener el código y nombre de aquellos cajeros que hayan realizado ventas en pisos cuyas ventas totales sean inferiores a los 5000 pesos.
