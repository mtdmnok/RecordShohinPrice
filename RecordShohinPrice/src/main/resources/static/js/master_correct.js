function correctButtonClick() {
	//項目（店舗、品目、商品名、ユーザー名）と、そのidを渡す。
	//項目
	var selectedItem = "";
	//id
	var selextedId = "";
	
	check1 = document.getElementById("radio1");
	check2 = document.getElementById("radio2");
	check3 = document.getElementById("radio3");
	check4 = document.getElementById("radio4");
	
	// 店舗
	if (check1.checked == true) {
		inputItem = document.getElementsByName('shop_name');
		selectedItem = "1"
	// 品名
	} else if (check2.checked == true) {
		inputItem = document.getElementsByName('category_name');
		selectedItem = "2"
	// 商品名
	} else if (check3.checked == true) {
		inputItem = document.getElementsByName('item_name');
		selectedItem = "3"
	// ユーザー名
	} else if (check4.checked == true) {
		inputItem = document.getElementsByName('user_name');
		selectedItem = "4"
	}
	
	// id取得
	var tbl = document.getElementById('resistTable');
	// テーブル行数取得
	let rowNum = tbl.rows.length;
	if(rowNum > 2){
		for(i=1; i<rowNum - 1; i++){
			var radio = tbl.rows[i].cells[0].input;
			if (radio.checked==true){
				selextedId = tbl.rows[i].cells[1].id;
				break;
			}
		}
	}

	
var dt = {selectRadioItem:selectedItem, selectedId:selextedId};
	
	$.ajax({
		url: "/correctMaster",
		dataType: "text",
		type: "GET",
		data: dt
		// Ajaxが正常終了した場合
	}).done(function(data, textStatus, jqXHR){
		if(!data){
			alert("該当するデータはありません");
			return;
		}
	});
}