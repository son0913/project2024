/**
 * 
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
	
	
	
function forum(){
	localStorage.setItem("page", 1);
	window.location.href = "/forum"
};