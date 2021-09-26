


function OnButtonClick() {
	// 選択項目
	var selectedItem = 0;
	// 入力項目
	var inputItem = "";
	
	// ラジオボタンの値取得でエラーとなってしまう。
	check1 = document.getElementById("radio1");
	check2 = document.getElementById("radio2");
	check3 = document.getElementById("radio3");
	check4 = document.getElementById("radio4");
	
	if (check1 == true) {
		inputItem = document.getElementById('shop_name').value;
	}
	
	
	// 選択されている項目を特定
	//for(var i=1; i<document.selectRadioItem.length; i++){
		// i番目のラジオボタンがチェックされているか判定
		if(document.selectRadioItem[i-1].checked){
			selectedItem = i;
			if(i==1){
				inputItem = document.getElementById('shop_name').value;
			} else if(i==2){
				inputItem = document.getElementById('category_name').value;
			} else if(i==3){
				inputItem = document.getElementById('item_name').value;
			} else if(i==4){
				inputItem = document.getElementById('user_name').value;
			}
			//break;
		}
	//}
	
	
	
	var dt = {selectRadioItem:selectRadioItem, inputItem:inputItem};
	
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
		// データをテーブルタグに表示
		const tableList = JSON.parse(data);
		let i = 0;
		for(i=0; i<tableList.length; i++){
			let trTag = $("<tr />");
			trTag.append($("<td></td>").text(decodeURI(tableList[i].shop_name)));
            $('#resistTable').append(trTag);
		}
		// Ajaxが異常終了した場合
	}).fail(function(jqXHR, textStatus, errorThrown ) {
		alert("エラーが発生してデータ取得できませんでした");
	});
}