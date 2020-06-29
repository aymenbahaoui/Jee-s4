/**
 * 
 */
var i = 1 ; 
	$(document).ready(function(){
		$("#add").click(function(){
			i++;
			$(`#question${i-1}`).after(`<div id ="question${i}"><label for="q${i}">Q${i}</label> <input type="text" name="q${i}" id="q${i}"/></div>`);
			$(`#question${i}`).hide().show(500);
			


		}
		) ;
  		
  		$("#remove").click(function(){
  			if(i>=2){
  				$(`#question${i}`).hide(500,function(){$(this).remove();});
				i--;
			}


		}
		) ;

	});