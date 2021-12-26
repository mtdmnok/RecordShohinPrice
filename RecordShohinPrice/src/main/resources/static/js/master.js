
// java scriptが読み込まれているかテスト
$(function(){
	console.log('test');
})


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
		// 編集ボタンの数
		var numOfEdtbtn = document.getElementsByClassName("edtbtn").length;
		// 編集ボタン押下不可にする
		for(i=1; i<=numOfEdtbtn; i++){
			var btnId = "edtBtn" + i
			document.getElementById(btnId).setAttribute("disabled", true);
		}
		// 登録ボタンを押下不可にする
		document.getElementById("registerBtn").setAttribute("disabled", true);
		// 修正ボタンを押下不可にする
		document.getElementById("correctBtn").setAttribute("disabled", true);
	});
});



// 【　クリックしたテーブルのセルを編集可能にする　】
$(function() {
	$("td").dblclick(function() {
		var td = $(this), originalContent = td.text();
		
		td.addClass("cellEditing");
		td.data("originalContent", originalContent);
	    var el = document.createElement("input"), $el = $(el);
	    $el.attr({type: "text", value: originalContent});
	    $el.css("fontSize", td.css("fontSize"));
	    td.empty();
	    td.append(el);
	    $el.focus();
	    
	    $el.keypress(function(e) {
	        if (e.which == 13) {
	          var text = $(this), newContent = text.val(), td = text.parent();
	          td.text(newContent);
	          td.removeData("originalContent");
	          td.removeClass("cellEditing");
	        }
	    });
	    var resetContent = function(e) {
	        var td = $(e.target).parent();
	        td.text(td.data("originalContent"));
	        td.removeData("originalContent");
	        td.removeClass("cellEditing");
	      };

	      $el.keydown(function(e) {
	        if (e.which == 27) {
	          resetContent(e);
	        }
	      });

	      $el.blur(resetContent);
	});
});

function editRow(obj){
	var objTR = obj.parentNode.parentNode;
	var rowId = objTR.sectionRowIndex;
	var objInp = document.getElementById("txt" + rowId);
	var objBtn = document.getElementById("edtBtn" + rowId);
	if(!objInp || !objBtn){
		return;
	}
	if(objBtn.value == "編集"){
		objInp.style.cssText = "border:1px solid #888;"
		objInp.readOnly = false;
		objInp.focus();
		objBtn.value = "確定";
	} else {
		objInp.style.cssText = "border:none;"
			objInp.readOnly = true;
		objBtn.value = "編集";
	}
}




//
//$(function($, document) {
//	  $.fn.tablecelleditor = function(options) {
//	    var settings = $.extend(true, {}, $.fn.tablecelleditor.defaults, options);
//	    return $(this).each(function() {
//	      $(this).dblclick(function() {
//	        $.fn.tablecelleditor.startEdit($(this), settings);
//	      });
//	    });
//	  };
//	  $.fn.tablecelleditor.defaults = function(){
//	    inputCSS: {
//	      border: 0;
//	      width: "100%";
//	    }
//	  };​
//	  $.fn.tablecelleditor.startEdit = function(td, settings) {
//	    var originalContent = td.text();
//	    td.addClass("cellEditing");
//	    td.data("originalContent", originalContent);
//	    var el = document.createElement("input"), $el = $(el);
//	    $el.attr({type: "text", value: originalContent});
//	    $el.css("fontSize", td.css("fontSize"));
//	    $el.css(settings.inputCSS);
//	    td.empty();
//	    td.append(el);
//	    $el.focus();​
//	    $el.keypress(function(e) {
//	      if (e.which == 13) {
//	        $.fn.tablecelleditor.commitEdit(e, settings);
//	      }
//	    });
//	    $el.keydown(function(e) {
//	      if (e.which == 27) {
//	        $.fn.tablecelleditor.resetEdit(e, settings);
//	      }
//	    });
//	    $el.blur(function(e) {
//	      $.fn.tablecelleditor.resetEdit(e, settings);
//	    });
//	  };​
//	  $.fn.tablecelleditor.commitEdit = function(e) {
//	    var text = $(e.target), newContent = text.val(), td = text.parent();
//	    td.text(newContent);
//	    td.removeData("originalContent");
//	    td.removeClass("cellEditing");
//	  };
//	  $.fn.tablecelleditor.resetEdit = function(e) {
//	    var td = $(e.target).parent();
//	    td.text(td.data("originalContent"));
//	    td.removeData("originalContent");
//	    td.removeClass("cellEditing");
//	  };
//	}(jQuery, document));
//
//
//$(function() {
//	  $("td").tablecelleditor({
//	    inputCSS: {
//	      "background-color": "rgb(255,253,210)"
//	    }
//	  });
//	});











//// これだと、テーブルをクリックしたときに反応する。しかし、セルの選択はできない。
//$(function(){
//	var tt = document.getElementById("resistTable");
//	tt.onclick = function(){
//		$(this).addClass('editing');
//		$(this).html('<input type="text" value="' + $(this).text() +'" />');
//		$(this).children().first().focus();
//	}
//});
//
//// テーブルをクリックしても、反応しない。
//$(function() {
//	$('#resistTable td').on('click', function() {
//		if (! $(this).hasClass('editing')) {
//			$(this).addClass('editing');
//			$(this).html('<input type="text" value="' + $(this).text() +'" />');
//			$(this).children().first().focus();
//		}
//	});
//	$('#target-table td').on('blur', 'input[type="text"]', function() {
//		$(this).parent().removeClass('editing');
//		$(this).parent().text($(this).val());
//	});
//});
//
//// 反応しない。
//$(function() {
//	  $("td").dblclick(function() {
//	    var td = $(this), originalContent = td.text();
//
//	    td.addClass("cellEditing");
//	    td.data("originalContent", originalContent);
//	    var el = document.createElement("input"), $el = $(el);
//	    $el.attr({type: "text", value: originalContent});
//	    td.empty();
//	    td.append(el);
//	    $el.focus();
//
//	    $el.keypress(function(e) {
//	      if (e.which == 13) {
//	        var text = $(this), newContent = text.val(), td = text.parent();
//	        td.text(newContent);
//	        td.removeData("originalContent");
//	        td.removeClass("cellEditing");
//	      }
//	    });
//
//	    var resetContent = function(e) {
//	      var td = $(e.target).parent();
//	      td.text(td.data("originalContent"));
//	      td.removeData("originalContent");
//	      td.removeClass("cellEditing");
//	    };
//
//	    $el.keydown(function(e) {
//	      if (e.which == 27) {
//	        resetContent(e);
//	      }
//	    });
//
//	    $el.blur(resetContent);
//	  });
//	});


