/**
 * 
 */
let commentService = (function(){
	function setContextPath(contextPath){
		//contextPath 설정
		this.contextPath = contextPath;
	}
	function ajaxPost(vo, url, success){
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
	function ajaxGet(url, success){
		$.ajax({
	        async:false,
	        type:'GET',
	        url:this.contextPath + url,
	        dataType:"json",
	        success : function(res){
	        	success(res);
	        }
	    });
	}
	return{
		name : 'commentService',
		contextPath : '',
		setContextPath : setContextPath,
		insert : ajaxPost,
		list : ajaxGet,
		delete : ajaxGet,
		modify : ajaxPost
	}
})();