<?php
// Ejercicio 18: Encuesta de comidas favoritas
// Guarda respuestas de usuarios en Auxiliar/comidas.txt y genera ranking

$comida = readline("¿Cuál es tu comida favorita? ");
file_put_contents('Auxiliar/comidas.txt', $comida . "\n", FILE_APPEND);

$comidas = file('Auxiliar/comidas.txt', FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);
$conteos = array_count_values($comidas);
arsort($conteos);

echo "Ranking de comidas favoritas:\n";
foreach ($conteos as $comida => $count) {
    echo "$comida: $count\n";
}
?>
