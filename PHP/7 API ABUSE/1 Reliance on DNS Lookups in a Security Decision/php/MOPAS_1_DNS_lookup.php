<?php
/**
 *  MOPAS Reliance on DNS Lookups in a Security Decision Example 1
 */
$hostName = gethostbyaddr($_SERVER['REMOTE_ADDR']);

$trustedHostName = 'partner.trustme.com';
$trusted = FALSE;

$pos = strrpos($hostName, $trustedHostName, -1);

if($pos !== FALSE) {
	$trusted = TRUE;
}

if ($trusted) {
	//do something
}
?>