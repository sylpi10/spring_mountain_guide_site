let menu = document.querySelector(".home-body>header>nav");

window.onscroll = ()=> {
    changeNavBg()
};

function changeNavBg() {
   if(window.innerWidth > 740){
      if (document.body.scrollTop > 50 || document.documentElement.scrollTop > 50) {
        menu.style.backgroundColor= "rgba( 42, 82, 141, .98)";
      } else {
            menu.style.backgroundColor= "rgba( 42, 82, 141, 0)";
      }
   }

}