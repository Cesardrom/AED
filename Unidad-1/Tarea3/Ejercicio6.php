<?php
    $filename_1 = "Auxiliar/frase.txt";
    $filename_2 = "Auxiliar/frase_invertida.txt";
    file_put_contents($filename_1, "Holiwi");
    $text = file_get_contents($filename_1);
    $inverted_text = strrev($text);
    $file = file_put_contents($filename_2, $inverted_text);
?>