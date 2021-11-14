


function OnButtonClick() {
	// 選択項目
	var selectedItem = 0;
	// 入力項目
	var inputItem = "";
	var targetItem = "";
	
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
			var seq = i + 1;
			var txtSeq = "txt" + String(seq);
			var btnSeq = "edtBtn" + String(seq);
			let trTag = $("<tr />");
			if(i==0){
				trTag.append("<td><input type=\"radio\"  name=\"radioResult\" class=\"tableRadio\" id=\"rd\"" + seq + " checked></input></td>");
			} else {
				trTag.append("<td><input type=\"radio\" name=\"radioResult\" class=\"tableRadio\" id=\"rd\"" + seq + "></input></td>");
			}
			//trTag.append($("<td></td>").text(decodeURI(JSON.parse(tableList[i]).shop_name));
			trTag.append("<td><input type= \"text\" value= \"" + decodeURI(JSON.parse(tableList[i]).shop_name)+ "\"" + "id=" + txtSeq +" style=\"border: none;\" readOnly></input></td>")
			trTag.append("<input type= \"hidden\" value= \"" + decodeURI(JSON.parse(tableList[i]).shop_id)+ "\"" + "id=" + txtSeq +" readOnly></input>")
			trTag.append("<td><input class=\"edtbtn\" type=\"button\" id=\"" + btnSeq + "\"value=\"編集\" onclick=\"editRow(this)\"</td>");
			//placeholder使う場合
//			trTag.append("<td width=\"20%\"><input type= \"text\" placeholder= \"" + decodeURI(JSON.parse(tableList[i]).shop_name) +"\"" +"></input></td>")
            $('#resistTable').append(trTag);
		}
		// Ajaxが異常終了した場合
	}).fail(function(jqXHR, textStatus, errorThrown ) {
		alert("エラーが発生してデータ取得できませんでした");
	});
}

