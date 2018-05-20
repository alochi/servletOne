$(".m_editstud").click(function(){
    document.getElementById("win_editStud").removeAttribute("style");
    var id=$(this).attr("idstud");
    var name=$(this).attr("namestud");
    var login=$(this).attr("loginstud");
    var pass=$(this).attr("passwordhashstud");
    document.getElementById("m_id").value = id;
    document.getElementById("m_name").value = name;
    document.getElementById("m_login").value = login;
    document.getElementById("m_pass").value = pass;
});