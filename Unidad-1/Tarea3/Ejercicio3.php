<?php
    $filename = "Auxiliar/texto.txt";
    file_put_contents($filename, "PHP es muy divertido y potente");
    $text = file_get_contents($filename);
    echo str_word_count($text);
?>