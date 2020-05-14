let activator = document.querySelector(".slider01-act");
let slider = document.querySelector(".slider01");
let close = document.querySelector(".close-slider");

activator.addEventListener("click", function (e){
       slider.style.display = "block";
       activator.style.display = "none";
});

close.addEventListener("click", function (e){
       slider.style.display = "none";
       activator.style.display = "block";
});


