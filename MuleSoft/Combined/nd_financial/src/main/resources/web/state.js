const state = {
    user: {
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
    },
    login: {
        username: '',
        password: '',
        display: '',
        msg: ''
    }
}

const config = {
    url: "http://localhost:8001/api/retail"
}