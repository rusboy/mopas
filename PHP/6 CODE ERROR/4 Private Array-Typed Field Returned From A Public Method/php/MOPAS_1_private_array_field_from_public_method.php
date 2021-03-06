<?php
/**
 *  MOPAS Private Array-Typed Field Returned From A Public Method Example 1
 */
class Test {
	private $colors = array('red', 'green', 'blue');
	
	public function &GetColorsRef(){
		return $this->colors;
	}
	
	public function GetColorsVal(){
		return $this->colors;
	}
}

$test = new Test;
$colors = & $test->GetColorsRef();
$colors[] = 'black';

foreach ($test->GetColorsVal() as $color) {
	echo $color . ', ';
}
?>