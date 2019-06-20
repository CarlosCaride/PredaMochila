# UNED - Ingeniería Informática - Programación y Estructuras Avanzadas

## PED 1 - Problema de la mochila con objetos no fraccionables

### Introducción
En informática, la **programación dinámica** es un método para reducir el tiempo de ejecución de un algoritmo mediante la utilización de subproblemas superpuestos y subestructuras óptimas. Una sub estructura óptima significa que se pueden usar soluciones óptimas de subproblemas para encontrar la solución óptima del problema en su conjunto. [Wikipedia](https://es.wikipedia.org/wiki/Programaci%C3%B3n_din%C3%A1mica)

En general, se pueden resolver problemas con subestructuras óptimas siguiendo estos tres pasos:

1. Dividir el problema en subproblemas más pequeños.
2. Resolver estos problemas de manera óptima usando este proceso de tres pasos recursivamente.
3. Usar estas soluciones óptimas para construir una solución óptima al problema original.

Los subproblemas se resuelven a su vez dividiéndolos en subproblemas más pequeños hasta que se alcance el caso fácil, donde la solución al problema es trivial.

Este proyecto es la PED 2 realizada durante el curso 2017-2018 para la asignatura de **Programación y Estructuras Avanzadas**, del grado de **Ingenieria informática**

## ENUNCIADO DE LA PRÁCTICA: Problema de la mochila con objetos no fraccionables

Se tiene una mochila con una capacidad máxima V y n objetos con volúmenes v = (v1; v2; ... ; vn) y benefícios b = (b1; b2; ... ; bn). Los valores de los volúmenes son enteros. El objetivo de este problema es encontrar una selección de objetos cuya suma de volúmenes no supere la capacidad máxima de la mochila, y de forma que la suma de benefícios sea máxima. Por lo tanto es un problema de optimización con restricciones.

En esta versión del problema los objetos son indivisibles, con lo que sólo tenemos la opción de incluirlos o excluirlos. Este hecho hace que no se pueda aplicar un algoritmo voraz. Se pide que se desarrolle el programa que resuelva este problema mediante el esquema de programación dinámica.

## Descripción del esquema algorítmico utilizado y como se aplica al problema

Se tiene una mochila con una capacidad máxima de V y n objetos con volúmenes v = (v1; v2; ... ; vn) y benefícios b = (b1; b2; ... ; bn). Los valores de los volúmenes son enteros. El objetivo de este problema es encontrar una selección de objetos cuya suma de volúmenes no supere la capacidad máxima de la mochila, y de forma que la suma de benefícios sea máxima. Este es un problema de optimización con restricciones que se puede plantear de la siguiente forma:

![equation](http://bit.ly/2L3TaZr)

Vea la documentación aportada en el repositorio para la solucón completa.