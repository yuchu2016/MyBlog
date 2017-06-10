var currentPosition,timer;  
function GoTop(){  
timer=setInterval("runToTop()",1);  
}  
function runToTop(){  
currentPosition=document.documentElement.scrollTop || document.body.scrollTop; 
currentPosition-=10;  
if(currentPosition>0)  
{  
window.scrollTo(0,currentPosition);  
}  
else  
{  
window.scrollTo(0,0);  
clearInterval(timer);  
}  
}