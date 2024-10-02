/**
 header, footer html 랜더링
 */
fetch('/home/header.html')
	.then(response => response.text())
	.then(data => {
	  document.getElementById('header-container').innerHTML = data;
	})
	.catch(error => console.error('Error loading header:', error));
	
fetch('/home/footer.html')
  .then(response => response.text())
  .then(data => {
    document.getElementById('footer-container').innerHTML = data;
  })
  .catch(error => console.error('Error loading header:', error));	
	
	
/*
메뉴 이동
*/	
function forum(){
	localStorage.setItem("page", 1);
	window.location.href = "/forum";
};


/*
로그인 버튼 기능 
 */
var loginPopFlag = "N";
function loginPop(){
	if(loginPopFlag == "N"){
		$(".login-form").css("display", "block");
		loginPopFlag ="Y";
	}else{
		$(".login-form").css("display", "none");
		loginPopFlag ="N";
	}
}

/*
간편 로그인
 */
var REST_API_KEY = "";
var REDIRECT_URI = "";
function easyLogin(arg){
	if("kakao" == arg){
		REST_API_KEY = "e2f96f0e3c7ba86cd6538a3f46f7b919";
		REDIRECT_URI = "http://localhost:8080/login/oauth/kakao/authorize/callback";
		window.open(`https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=${REST_API_KEY}&redirect_uri=${REDIRECT_URI}`);
	}else if("naver" == arg){
		
	}
}