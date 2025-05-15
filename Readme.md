# Procesamiento de Ventas Mensuales (Java)

Este proyecto implementa un ejercicio en Java que simula el procesamiento de ventas mensuales utilizando matrices y secuencias de números. El objetivo principal es identificar secuencias de ventas diarias dentro de un mes, calcular su promedio, y eliminar aquellas que no superan un valor mínimo definido.

## 📋 Descripción

Dado un arreglo bidimensional que representa las ventas diarias de distintos meses, el programa:

- Recorre las secuencias de números no nulos (delimitadas por ceros) en ciertos meses específicos.
- Calcula el promedio de cada secuencia.
- Si el promedio supera un valor umbral (`X = 200`), la secuencia se considera válida y se cuenta.
- Si el promedio no supera el umbral, la secuencia se elimina mediante un corrimiento a la izquierda en el arreglo.
- Finalmente, informa cuántas secuencias válidas hay en cada mes evaluado.

⚠️ **Nota:** Solo se procesan los meses indicados en el arreglo `meses`. Por ejemplo, si `meses = {1, 3, 0}`, se procesan únicamente el mes 1 y el mes 3. El `0` indica fin de datos.

## ⚙️ Detalles Técnicos

- Lenguaje: Java
- Constantes:
  - `MAXFILAS = 3`: número de meses (filas de la matriz)
  - `MAXCOL = 15`: cantidad de días por fila (columnas)
  - `X = 200`: valor mínimo promedio de ventas para considerar la secuencia válida
  - `SEP = 0`: valor separador entre secuencias
- El procesamiento se realiza sobre la matriz `ventasMensuales` y el arreglo `meses`.

## 💡 Ejemplo de salida esperada

El programa imprime la matriz original, procesa las ventas de los meses indicados en el array `meses`, e imprime la matriz modificada junto con un resumen por mes.

```text
Matriz original:
Mes 1: 0 | 0 | 150 | 200 | 165 | 0 | 154 | 352 | 240 | 256 | 0 | 900 | 750 | 0 | 0 |
Mes 2: 0 | 940 | 105 | 265 | 845 | 215 | 0 | 245 | 65 | 48 | 0 | 741 | 125 | 541 | 0 |
Mes 3: 0 | 851 | 543 | 625 | 845 | 914 | 0 | 754 | 184 | 0 | 637 | 917 | 0 | 0 | 0 |

Para el mes 1 la cantidad de secuencias con promedio mayor a $200 es de 1 secuencia(s)
Para el mes 3 la cantidad de secuencias con promedio mayor a $200 es de 2 secuencia(s)

Matriz resultante (con secuencias eliminadas si no cumplen condición):
Mes 1: 0 | 0 | 0 | 154 | 352 | 240 | 256 | 0 | 900 | 750 | 0 | 0 | 0 | 0 | 0 |
Mes 2: 0 | 940 | 105 | 265 | 845 | 215 | 0 | 245 | 65 | 48 | 0 | 741 | 125 | 541 | 0 |
Mes 3: 0 | 851 | 543 | 625 | 845 | 914 | 0 | 754 | 184 | 0 | 637 | 917 | 0 | 0 | 0 |
