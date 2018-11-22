const regForm = () => {
    return (`
    <form id='regForm'>
            <div>
                <label for='name'>Name:<input type='text' name='name' placeholder='enter name' /></label>
            </div>
            <div>
                <label for='username'>Username:<input type='text' name='username' placeholder='enter username' required /></label>
            </div>
            <div>
                <label for='password'>Password:<input type='password' name='password' placeholder='enter password'
                        required /></label>
            </div>
            <div>
                <label for='gender'>Gender:<input type='text' name='gender' placeholder='enter gender' /></label>
            </div>
            <div>
                <label for='ethnicity'>Ethnicity:<input type='text' name='ethnicity' placeholder='enter ethnicity' /></label>
            </div>
            <div>
                <label for='dob'>Date of Birth:<input type='date' name='dob' placeholder='enter dob' /></label>
            </div>
            <div>
                <label for='address'>Address:<input type='text' name='address' placeholder='enter address' /></label>
            </div>
            <div>
                <label for='email'>Email:<input type='email' name='email' placeholder='enter email' required /></label>
            </div>
            <div>
                <label for='phone'>Phone Number:<input type='tel' name='phone' placeholder='enter phone number' /></label>
            </div>
            <div>
                <label for='occupation'>Occupation:<input type='text' name='occupation' placeholder='enter occupation' /></label>
            </div>
            <div>
                <label for='salary'>Salary:<input type='number' name='salary' placeholder='enter yearly salary' /></label>
            </div>
        </form>
        <input type='button' value='Clear' id='btnClear' />
        <input type='button' value='Submit' id='btnSubmit' />
        <div id='error'></div>
    </div>
    `);
}

const clearUser = () => {
    state.user = {
        id: '',
        name: '',
        username: '',
        password: '',
        gender: '',
        ethnicity: '',
        dob: '',
        address: '',
        email: '',
        phone: '',
        occupation: '',
        salary: '',
        active: true
    }
    $("input[name='name']").val('');
    $("input[name='username']").val('');
    $("input[name='password']").val('');
    $("input[name='gender']").val('');
    $("input[name='ethnicity']").val('');
    $("input[name='dob']").val('');
    $("input[name='address']").val('');
    $("input[name='email']").val('');
    $("input[name='name']").val('');
    $("input[name='occupation']").val('');
    $("input[name='salary']").val('');

    $('#error').html('');
}

const loadUser = () => {
    $("input[name='name']").val(state.user.name);
    $("input[name='username']").val(state.user.username);
    $("input[name='password']").val(state.user.password);
    $("input[name='gender']").val(state.user.gender);
    $("input[name='ethnicity']").val(state.user.ethnicity);
    $("input[name='dob']").val(state.user.dob);
    $("input[name='address']").val(state.user.address);
    $("input[name='email']").val(state.user.email);
    $("input[name='name']").val(state.user.name);
    $("input[name='occupation']").val(state.user.occupation);
    $("input[name='salary']").val(state.user.salary);
}

const setPayload = () => {
    user = {
        id: '',
        name: $("input[name='name']").val(),
        username: $("input[name='username']").val(),
        password: $("input[name='password']").val(),
        gender: $("input[name='gender']").val(),
        ethnicity: $("input[name='ethnicity']").val(),
        dob: $("input[name='dob']").val(),
        address: $("input[name='address']").val(),
        email: $("input[name='email']").val(),
        phone: $("input[name='name']").val(),
        occupation: $("input[name='occupation']").val(),
        salary: $("input[name='salary']").val(),
        active: true
    }
    return user
}

const getUser = async () => {

}

const submitForm = async () => {

    if (!$('#regForm')[0].checkValidity()) {

        $('#error').html('Please Fill out the Form Completely!')
        return;
    }

    try {
        let body = setPayload();
        console.log(body);
        let fetchConfig = {
            method: 'post',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(body)
        }

        let response = await fetch(`${config.url}/user`, fetchConfig);
        let data = await response.json();
        state.user.id = data.message;
        if (!data.message) {
            $('#error').html('An Error Has Occured')
        } else {
            window.location.replace(`home.html/?id=${data.message}`)
        }
    } catch (e) {
        console.log(e);
    }

}

const loadForm = () => {
    $('#body').html(regForm)
}