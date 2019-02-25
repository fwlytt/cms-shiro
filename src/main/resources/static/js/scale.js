/*----------------------------------------------------------*/
$(function() {
	var oBdoy = document.getElementsByTagName('html')[0];
	var domWidht = document.documentElement.clientWidth;
	var domHeight = document.documentElement.clientHeight;
	var myScale = domWidht / 1024;
	var myHeight = domHeight / myScale;
	var sh = document.body.scrollHeight * myScale;
	var sh1 = document.body.scrollHeight / myScale;
	var bh = $(".bged").height() + 20;

	if (domWidht >= 1024) {
		//	oBdoy.style.transform = 'scale(' + myScale + ')';
		//	oBdoy.style.transformOrigin = '50% ' + 0 + '%';
		if (domWidht <= 768) {
			$("body").css("width", "100%");
		}
		$("html").height(domHeight);
		/*---- btn-pay位置  ----*/
		if (domHeight < (bh + 210)) {
			$(".btn-pay").css({
				'position' : 'initial'
			});
			if (domHeight <= (bh + 90)) {
				$(".btn-pay").css({
					'margin' : '40px auto 120px'
				});
			}
		}
		/*--------------------*/
	} else if (domWidht < 1024) {
		oBdoy.style.transform = 'scale(' + myScale + ')';
		oBdoy.style.transformOrigin = '0' + 0 + '%' + 0;
		$("html").height(myHeight);
		/*---- btn-pay位置  ----*/
		if (myHeight < (bh + 210)) {
			$(".btn-pay").css({
				'position' : 'initial'
			});
			if (myHeight <= (bh + 90)) {
				$(".btn-pay").css({
					'margin' : '40px auto 120px'
				});
			}
		}
		/*--------------------*/
	} else {
		oBdoy.removeAttribute('style', 'transform');
		oBdoy.removeAttribute('style', 'transformOrigin');

	}

})