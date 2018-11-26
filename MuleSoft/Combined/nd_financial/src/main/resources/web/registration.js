const regForm = () => {
    return (`
    <form id='regForm' class="pure-form pure-form-aligned">
        <fieldset>
            <div class="pure-control-group">
                <label for='name'>Name:</label><input type='text' name='name' placeholder='enter name' />
            </div>
            <div class="pure-control-group">
                <label for='username'>Username:</label><input type='text' name='username' placeholder='enter username' required />
            </div>
            <div class="pure-control-group">
                <label for='password'>Password:</label><input type='password' name='password' placeholder='enter password'
                        required />
            </div>
            <div class="pure-control-group">
                <label for='gender'>Gender:</label><input type='text' name='gender' placeholder='enter gender' />
            </div>
            <div class="pure-control-group">
                <label for='ethnicity'>Ethnicity:</label><input type='text' name='ethnicity' placeholder='enter ethnicity' />
            </div>
            <div class="pure-control-group">
                <label for='dob'>Date of Birth:</label><input type='date' name='dob' placeholder='enter dob' />
            </div>
            <div class="pure-control-group">
                <label for='address'>Address:</label><input type='text' name='address' placeholder='enter address' />
            </div>
            <div class="pure-control-group">
                <label for='email'>Email:</label><input type='email' name='email' placeholder='enter email' required />
            </div>
            <div class="pure-control-group">
                <label for='phone'>Phone Number:</label><input type='tel' name='phone' placeholder='enter phone number' />
            </div>
            <div class="pure-control-group">
                <label for='occupation'>Occupation:</label><input type='text' name='occupation' placeholder='enter occupation' />
            </div>
            <div class="pure-control-group">
                <label for='salary'>Salary:</label><input type='number' name='salary' placeholder='enter yearly salary' />
            </div>
            </fieldset>
        </form>
        <input type='button' value='Clear' id='btnClear' class='pure-button'/>
        <input type='button' value='Submit' id='btnSubmit' class='pure-button'/>
        <div id='error'></div>
    </div>
    `);
}

const clearUser = (e) => {
    event.stopPropagation();
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
    $("input[name='phone']").val('');
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
    $("input[name='phone']").val(state.user.phone);
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
        phone: $("input[name='phone']").val(),
        occupation: $("input[name='occupation']").val(),
        salary: $("input[name='salary']").val(),
        active: true
    }
    return user
}

const getUser = async () => {

}

const submitForm = async () => {
    event.stopImmediatePropagation();
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
            window.location.replace(`http://localhost:5500/index.html/${data.message}`)
        }
    } catch (e) {
        console.log(e);
    }

}

const loadForm = () => {
    $('#body').html(regForm)
}