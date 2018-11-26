const formBox = () => {
    $('#body').html(`
        <div class = 'formBox pure-form pure-form-aligned'></div>
    `);
    let container = () => {
        return (`
        <fieldset>
            <div>
                ${
            state.login.display === 'username' ?
                usernameBox(state.login.username) :
                passwordBox(state.login.password)
            }
            </div>
            <div>${state.login.msg}</div>
            <div>
                ${
            state.login.display === 'username' ?
                `<input class = 'btnPassword pure-button' type = 'button' name ='btnEnterPassword' value ='Enter Password' />` :
                `<input class = 'btnUsername pure-button' type = 'button' name = 'btnEnterUsername' value ='Back' />
                    <input class = 'btnLogin' type = 'button' name ='btnLogin' value = 'Login'/>`


            }
            </div>
        </fieldset>
        `);
    }
    return container();
}

const usernameBox = (username) => {
    return (`
        <div>
            <label for = "loginName">Username: </label>
            <input class = 'username' type = "text" value = "${username}" name = "loginName" />
        </div>
    `);
}

const passwordBox = (password) => {
    return (`
        <div>
            <label for = "loginPass">Password: </label>
            <input class = 'password' type = "text" value = "${password}" name = "loginPass" />
        </div>
    `)
}

const checkUserName = async (username) => {
    try {
        let response = await fetch(`${config.url}/user/login/${username}`);
        let json = await response.json();

        if (json.message === "okay") {
            return true
        } else {
            console.log(false)
            state.login.msg = "Username not found"
        }
        return false
    } catch (error) {
        console.log(error)
        return false
    }
}

const enterUsername = () => {
    let msg = state.login.msg;
    let username = state.login.username;
    state.login = {
        display: 'username',
        username: username,
        password: '',
        msg: msg
    }
    let template = formBox();
    $('.formBox').html(template);
}
const enterPassword = () => {
    let msg = state.login.msg;
    state.login = {
        display: 'password',
        username: $("input[name ='loginName']").val(),
        password: '',
        msg: msg

    }

    checkUserName(state.login.username).then(found => {
        if (found) {
            state.login.msg = '';
        } else {
            state.login.display = 'username';
        }

        let template = formBox();
        $('.formBox').html(template);
    })
}

const doLogin = async () => {
    try {

        let loginState = {
            username: state.login.username,
            password: $('.password').val()
        }
        console.log(loginState);
        let fetchConfig = {
            method: 'post',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(loginState)
        }

        let response = await fetch(`${config.url}/user/login`, fetchConfig);
        let data = await response.json();
        //login successful change code here for redirect
        if (data.message === 'okay') {
            window.location.replace(`http://localhost:5500/index.html/${state.user.username}`)
        } else {
            state.login.msg = 'wrong password';
            state.login.display = 'password';
            template = formBox();
        }
        $('.formBox').html(template);
    } catch (e) {
        console.log(e);
    }

}