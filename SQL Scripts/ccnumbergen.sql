select concat(format(cast(floor(RAND()*(9999-0+1)+10) as int), '0000'), 
' ', format(cast(floor(RAND()*(9999-0+1)+10) as int), '0000'), 
' ', format(cast(floor(RAND()*(9999-0+1)+10) as int), '0000'), 
' ', format(cast(floor(RAND()*(9999-0+1)+10) as int), '0000'));