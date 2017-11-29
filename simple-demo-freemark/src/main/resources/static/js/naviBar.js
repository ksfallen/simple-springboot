$(function(){
	var a = $('.LeftUl').find('li[style]').has('ul');
	if (a.length == 0) {
		var b = $('.LeftUl').find('li[style]');
		if (b.length > 0) {
			$(".nav b").text( $('.LeftUl').find('li[style]').find('a').text());
		}
	} else {
		var level1 = a.find('p').text();
		var level2 = a.find('li[style]').find('a').text();
		var lowerLevels = "";
		if(naviRely && naviRely.lowerLevels && naviRely.lowerLevels.length > 0){
			$.each(naviRely.lowerLevels,function(i,item){
				lowerLevels +='  >  ' + item;
			});
		}
		$(".nav b").text( level1 + '  >  ' + level2 + lowerLevels);
	}
});