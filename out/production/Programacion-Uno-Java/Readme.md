# Procesamiento de Ventas Mensuales (Java)

Este proyecto implementa un ejercicio en Java que simula el procesamiento de ventas mensuales utilizando matrices y secuencias de números. El objetivo principal es identificar secuencias de ventas diarias dentro de un mes, calcular su promedio, y eliminar aquellas que no superan un valor mínimo definido.

## 📋 Descripción

Dado un arreglo bidimensional que representa las ventas diarias de distintos meses, el programa:

- Recorre las secuencias de números no nulos (delimitadas por ceros) en ciertos meses específicos.
- Calcula el promedio de cada secuencia.
- Si el promedio supera un valor umbral (`X = 200`), se cuenta como válida.
- Si no lo supera, la secuencia es eliminada mediante corrimiento a la izquierda.
- Informa cuántas secuencias válidas hay en cada mes evaluado.

⚠️ **Nota:** Solo se procesan los meses indicados en el arreglo `meses`. Por ejemplo, si `meses = {1, 3, 0}`, se procesan únicamente el mes 1 y el mes 3. El `0` indica fin de datos.

## ⚙️ Detalles Técnicos

- Lenguaje: Java
- Constantes:
  - `MAXFILAS = 3`: número de meses (filas de la matriz)
  - `MAXCOL = 15`: cantidad de días por fila (columnas)
  - `X = 200`: valor mínimo promedio de ventas
  - `SEP = 0`: valor separador entre secuencias
- El procesamiento se realiza sobre la matriz `ventasMensuales` y el arreglo `meses`.

## 💡 Ejemplo de salida esperada

El programa imprime la matriz original, procesa las ventas de los meses indicados en el array `meses`, e imprime la matriz modificada junto con un resumen por mes.

```text
Para el mes 1 la cantidad de dias con un promedio mayor a $200 es de 1 dias
Para el mes 3 la cantidad de dias con un promedio mayor a $200 es de 2 dias
