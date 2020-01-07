var ele = document.createElement('p')

function showAlert() {
    alert("Hi Welcome to Cinima hall !! ")
}
function myCreateElements() {

    ele.textContent = "hiii"
    document.body.appendChild(ele)
}
function dtisplayElement() {
    var dispElement = document.getElementById('disp')
    var dispElement1 = document.getElementById('h1button')
    if (dispElement.style.display === ''
        || dispElement.style.display === 'none') {
        dispElement.style.display = 'block'
        dispElement1.textContent = 'Click this to hide h1 Element'
    } else {
        dispElement.style.display = 'none'
        dispElement1.textContent = 'Click this to show h1 Element'
    }
}
function changeToBlue() {
    var dispColor = document.getElementById('cgColor')
    dispColor.style.backgroundColor = 'blue'
    dispColor.style.fontSize = '35px'
}
function changeToWhite() {
    var dispColor = document.getElementById('cgColor')
    dispColor.style.backgroundColor = 'white'
    dispColor.style.fontSize = '15px'
}
function showDate(){
    console.log('working!!!');
    
}
function showDetail(){
    console.log('onkey down executed');
    
}
function getInputValue(){
    var inpElement = document.getElementById('inp')
    console.log(inpElement.value); 
    var showElement = document.getElementById('show')
    showElement.textContent = inpElement.value;
}