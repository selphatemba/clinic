/**
 * Created by SELPHA on 22/2/2018.
 */



function checkForm(form)
{
    if(form.jobid.value === "") {
        alert("Error: Username cannot be blank!");
        form.jobid.focus();
        return false;
    }
    re = /^\w+$/;
    if(!re.test(form.jobid.value)) {
        alert("Error: Username must contain only letters, numbers and underscores!");
        form.jobid.focus();
        return false;
    }
    if(form.password.value !== "" && form.password.value === form.password2.value) {
        alert("Error: Please check that you've entered and confirmed your password!");
        form.password.focus();
        return false;}
        else

    return true;
}
