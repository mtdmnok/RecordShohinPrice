
// java scriptが読み込まれているかテスト
$(function(){
	console.log('test');
})


//$('#searchBtn').click(function() {
//	var shop = $('input[name="shop_id"]').val();
//})

//document.getElementById("searchBtn").onclick = function(){
//	var shop = $('input[name="shop_id"]').val();
//	var category = $('input["category_id"]').val();
//	var item = $('input["item_id"]').val();
//	var user = $('input["user_id"]').val();
//	//入力が無い場合、""を代入する？
//	if(category == null){
//		$('input["category_id"]').val("");
//	}
//};

//$('#searchBtn').on('click', function(){
//	var shop = $('input[name="shop_id"]').val();
//	var category = $('input["category_id"]').val();
//	var item = $('input["item_id"]').val();
//	var user = $('input["user_id"]').val();
//	//入力が無い場合、""を代入する？
//	if(category == null){
//		$('input["category_id"]').val("");
//	}
//});

//　ラジオボタンを選択すると、表の項目名が変化する
$(function(){
	$( 'input[name="selectRadioItem"]:radio' ).change( function() {
		var radioval = $(this).val();
		if(radioval == 1){
			$('table#resistTable tbody tr th:nth-child(2)').text('店舗');
		} else if(radioval == 2){
			$('table#resistTable tbody tr th:nth-child(2)').text('品目');
		}　else if(radioval == 3){
			$('table#resistTable tbody tr th:nth-child(2)').text('商品名');
		} else if(radioval == 4){
			$('table#resistTable tbody tr th:nth-child(2)').text('ユーザー名');
		}
	});
});



