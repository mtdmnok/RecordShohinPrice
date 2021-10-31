
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


