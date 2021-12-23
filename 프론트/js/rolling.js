//위로 이동
function rollingToTop(parentSelector, childSelector, moveTime, animationTime){
	var height = $(parentSelector).height();
	return setInterval(function(){
		if(!$(parentSelector + '>' + childSelector).first().is(':animated')){
			$(parentSelector + '>' + childSelector).first().animate({marginTop: -height}, animationTime, function(){
			$(this).detach().appendTo(parentSelector).removeAttr('style');
			});
		}
	}, moveTime);
}
//왼쪽으로 이동
function rollingToLeft(ancestor, parentSelector, childSelector, moveTime, animationTime){
	return setInterval(function(){
		if(!$(ancestor + " " + childSelector).first().is(':animated')){
			var width = $(ancestor + " " + childSelector).width();
			$(ancestor + " " + childSelector).first().animate({marginLeft: -width}, animationTime, function(){
				$(this).removeAttr('style').detach().appendTo(parentSelector);
			});
		}
	}, moveTime);
}