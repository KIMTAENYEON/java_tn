//롤링기능
var issueAreaId;
issueAreaId = rollingToTop('.issue-area', 'li', 2000, 500);
//hover이벤트 등록
$('.contents-l-box2 .issue-area').hover(function(){
	clearInterval(issueAreaId);
	$(this).find('.link-issue').css('text-decoration', 'underline')
}, function(){
	issueAreaId = rollingToTop('.issue-area', 'li', 2000, 500);
	$(this).find('.link-issue').css('text-decoration', 'none')
});
var contentsId;

$(function(){		
	contentsId = rollingToLeft('.contents-view', '.contents-list', '.contents-item', 2000, 500);
	//hover이벤트 등록
	$('.contents-r-box2').hover(function(){
		clearInterval(contentsId);
	}, function(){
		contentsId = rollingToLeft('.contents-view', '.contents-list', '.contents-item', 2000, 500);
	});
	//이전버튼 클릭할 때
	$('.contents-r-box2 .prev-button').click(function(e){
		e.preventDefault();
		if(!$('.contents-item').first().is(':animated')){
				var width = $('.contents-view').width();
				$('.contents-item').last().detach().css('margin-left', -width + 'px').prependTo('.contents-list').animate({marginLeft: 0}, 500, function(){
				});
			}
	});
	//다음버튼 클릭할 때
	$('.contents-r-box2 .next-button').click(function(e){
		e.preventDefault();
		if(!$('.contents-item').first().is(':animated')){
				var width = $('.contents-view').width();
				$('.contents-item').first().animate({marginLeft: -width}, 500, function(){
					$(this).removeAttr('style').detach().appendTo('.contents-list');
				});
			}
	});		
});
