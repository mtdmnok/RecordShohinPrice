
// java scriptが読み込まれているかテスト
$(function(){
	console.log('test');
})

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
	$('resistTable thread tr')
	});

$('#searchBtn').on('click', function(){
	var shop = $('input[name="shop_id"]').val();
	var category = $('input["category_id"]').val();
	var item = $('input["item_id"]').val();
	var user = $('input["user_id"]').val();
	//入力が無い場合、""を代入する？
	if(category == null){
		$('input["category_id"]').val("");
	}
});

//　ラジオボタンを選択すると、表の項目名が変化するようにしたいが、変化なし
$(function(){
	$( 'input[name="selectItem"]:radio' ).change( function() {
		var radioval = $(this).val();
		if(radioval == 1){
			$('table#resistTable thread tr th:nth-child(2)').text('店舗');
		}
	});
});



