//跳转的页面
function toPage(formId, pageIndex) {
	$('#' + formId + ' #pageIndex').val(pageIndex);
	$('#' + formId).submit();
}

// 首页
function startPage(formId) {
	$('#' + formId + ' #pageIndex').val("1");
	$('#' + formId).submit();
}
// 末页
function endPage(formId, pageIndex) {
	$('#' + formId + ' #pageIndex').val(pageIndex);
	$('#' + formId).submit();
}
