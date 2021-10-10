


function OnButtonClick() {
	// 選択項目
	var selectedItem = 0;
	// 入力項目
	var inputItem = "";
	var targetItem = "";
	
	// ラジオボタンの値取得でエラーとなってしまう。
	check1 = document.getElementById("radio1");
	check2 = document.getElementById("radio2");
	check3 = document.getElementById("radio3");
	check4 = document.getElementById("radio4");
	
	// 店舗
	if (check1.checked == true) {
		inputItem = document.getElementsByName('shop_name');
		targetItem = inputItem[0].value;
		selectedItem = "1"
	// 品名
	} else if (check2.checked == true) {
		inputItem = document.getElementsByName('category_name');
		targetItem = inputItem[0].value;
		selectedItem = "2"
	// 商品名
	}　else if (check3.checked == true) {
		inputItem = document.getElementsByName('item_name');
		targetItem = inputItem[0].value;
		selectedItem = "3"
	// ユーザー名
	}　else if (check4.checked == true) {
		inputItem = document.getElementsByName('user_name');
		targetItem = inputItem[0].value;
		selectedItem = "4"
	}
	
	
	
	// 選択されている項目を特定
//	for(var i=1; i<document.selectRadioItem.length; i++){
//		// i番目のラジオボタンがチェックされているか判定
//		if(document.selectRadioItem[i-1].checked){
//			selectedItem = i;
//			if(i==1){
//				inputItem = document.getElementsByName('shop_name');
//			} else if(i==2){
//				inputItem = document.getElementsByName('category_name');
//			} else if(i==3){
//				inputItem = document.getElementsByName('item_name');
//			} else if(i==4){
//				inputItem = document.getElementsByName('user_name');
//			}
//			//break;
//		}
//	}
//	
	
	
	var dt = {selectRadioItem:selectedItem, inputItem:targetItem};
	
	$.ajax({
		url: "/resistMaster2",
		dataType: "text",
		type: "GET",
		data: dt
		// Ajaxが正常終了した場合
	}).done(function(data, textStatus, jqXHR){
		if(!data){
			alert("該当するデータはありません");
			return;
		}
		console.log(data);
		// データをテーブルタグに表示
		const tableList = JSON.parse(data);
		console.log(JSON.parse(tableList[0]).shop_name);
		let i = 0;
		for(i=0; i<tableList.length; i++){
			let trTag = $("<tr />");
			trTag.append("<td><input type=\"radio\" class=\"tableRadio\"></input></td>");
			trTag.append($("<td></td>").text(decodeURI(JSON.parse(tableList[i]).shop_name)));
            $('#resistTable').append(trTag);
		}
		// Ajaxが異常終了した場合
	}).fail(function(jqXHR, textStatus, errorThrown ) {
		alert("エラーが発生してデータ取得できませんでした");
	});
}