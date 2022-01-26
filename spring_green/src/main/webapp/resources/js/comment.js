/**
 * 
 */
let commentService = (function(){
	function setContextPath(contextPath){
		//contextPath 설정
		this.contextPath = contextPath;
	}
	function ajaxGet(vo, url, success){
		$.ajax({
	        async:false,
	        type:'POST',
	        data:JSON.stringify(vo),
	        url:this.contextPath + url,
	        dataType:"json",
	        contentType:"application/json; charset=UTF-8",
	        success : function(res){
	        	success(res);
	        }
	    });
	}
	return{
		name : 'commentService',
		contextPath : '',
		setContextPath : setContextPath,
		insert : ajaxGet
	}
})();