<?php
    $filename = "Auxiliar/datos_numericos.txt";
    file_put_contents($filename, "10,20");
    $numbers = file_get_contents($filename);
    $numbers = explode(',', $numbers);
    echo array_sum($numbers);
?>