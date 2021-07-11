

//function(){
//	$("#searchBtn").click(function(){
//		var radioVal = document.getElementsByName("selectItem").val();
//		$("#test").text(radioVal);
//	});
//}

//var table = document.getElementById('resistTable');

$('#searchBtn').on('click', function(){
	var table = document.getElementById('resistTable');
	var radioVal = document.getElementsByName('selectItem').val();
		//$('#test').text(radioVal);
	table.rows[0].cells[1].innerHTML = radioVal;
	});



