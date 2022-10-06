const sign_up = document.querySelector('#sign_up_link'),
    sign_in = document.querySelector('#sign_in_link'),
    sign_in_form = document.querySelector("#sign_in_form"),
    sign_up_form = document.querySelector("#sign_up_form");
sign_up.onclick= function (e) {
    sign_up_form.style.display = 'block';
    sign_in_form.style.display = 'none';
    document.title = 'Sign Up/The Gluck';
}
sign_in.onclick= function (e) {
    sign_in_form.style.display = 'block';
    sign_up_form.style.display = 'none';
    document.title = 'Sign In/The Gluck';
}