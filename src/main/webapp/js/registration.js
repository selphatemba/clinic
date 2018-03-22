/**
 * Created by SELPHA on 22/2/2018.
 */



function checkForm(form1)
{
    if(form1.jobid.value === "") {
        alert("Error: Username cannot be blank!");
        form1.jobid.focus();
        return false;
    }
    re = /^\w+$/;
    if(!re.test(form1.jobid.value)) {
        alert("Error: Username must contain only letters, numbers and underscores!");
        form1.jobid.focus();
        return false;
    }
    if(form1.password.value !== "" && form1.password.value === form1.password2) {
        alert("Error: Please check that you've entered and confirmed your password!");
        form1.password.focus();
        return false;}
        else

    return true;
}
