<?php
// Ejercicio 19: Simulador de tweets
// Guarda tweets en Auxiliar/tweets.txt con fecha y hora, muestra los últimos 5

$tweet = readline("Escribe tu tweet: ");
$fechaHora = date("Y-m-d H:i");
file_put_contents('Auxiliar/tweets.txt', "[$fechaHora] $tweet\n", FILE_APPEND);

$tweets = file('Auxiliar/tweets.txt', FILE_IGNORE_NEW_LINES);
$ultimos = array_slice($tweets, -5);

echo "Últimos 5 tweets:\n";
foreach ($ultimos as $t) {
    echo $t . "\n";
}
?>
