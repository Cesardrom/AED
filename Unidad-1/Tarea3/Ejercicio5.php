<?php
    $filename_1 = "Auxiliar/origen.txt";
    $filename_2 = "Auxiliar/copia.txt";
    file_put_contents($filename_1, "Hola PHP");
    $text = file_get_contents($filename_1);
    $copy = file_put_contents($filename_2, $text);
?>