"use strict";

// SELECTORS

// DIVS


// INPUTS
let inputID = document.querySelector("#inputID");
let inputFirstName = document.querySelector("#inputFirstName");
let inputSecondName = document.querySelector("#inputSecondName");
let inputAge = document.querySelector("#inputAge");
let inputContactNumber = document.querySelector("#inputContactNumber");
let inputEmail = document.querySelector("#inputEmail");

// BUTTONS
let createBtn = document.querySelector("#createBtn");
let updateBtn = document.querySelector("#updateBtn");
let deleteBtn = document.querySelector("#deleteBtn");
let getByIDBtn = document.querySelector("#getByIDBtn");
let getByFirstNameBtn = document.querySelector("#getByFirstNameBtn");
let getBySecondNameBtn = document.querySelector("#getBySecondNameBtn");
let getByAgeBtn = document.querySelector("#getByAgeBtn");

// FUNCTIONS
// Get All
let getAll = () => {
    axios.get("http://localhost:8080/student/getAll")
        .then(res => {
            console.log(res.data);
        }).catch(err => console.log(err));
}

// Get By ID
let getByID = () => {
    axios.get(`http://localhost:8080/student/getById/${inputID.value}`)
        .then(res => {
            console.log(res.data);
        }).catch(err => console.log(err));
}

// Get By First Name
let getByFirstName = () => {
    axios.get(`http://localhost:8080/student/getByFirstName/${inputFirstName.value}`)
        .then(res => {
            console.log(res.data);
        }).catch(err => console.log(err));
}

// Get Second Name
let getBySecondName = () => {
    axios.get(`http://localhost:8080/student/getBySecondName/${inputSecondName.value}`)
        .then(res => {
            console.log(res.data);
        }).catch(err => console.log(err));
}

// Get By Age
let getByAge = () => {
    axios.get(`http://localhost:8080/student/getByAge/${inputAge.value}`)
        .then(res => {
            console.log(res.data);
        }).catch(err => console.log(err));
}

// Create
let create = () => {

    if (!createValidation()) {
        alert("All required fields do not have values.")
        return;
    }

    let obj = {
        "firstName": inputFirstName.value,
        "secondName": inputSecondName.value,
        "age": inputAge.value,
        "contactNumber": inputContactNumber.value,
        "email": inputEmail.value
    }

    axios.post("http://localhost:8080/student/create", obj)
        .then(res => {
            console.log(res.data);
            getAll();
        }).catch(err => console.log(err));
}

// Update
let update = () => {

    if (!updateValidation()) {
        alert("All required fields do not have values.")
        return;
    }

    let obj = {
        "firstName": inputFirstName.value,
        "secondName": inputSecondName.value,
        "age": inputAge.value,
        "contactNumber": inputContactNumber.value,
        "email": inputEmail.value
    }

    axios.put(`http://localhost:8080/student/update/${inputID.value}`, obj)
        .then(res => {
            console.log(res.data);
            getAll();
        }).catch(err => console.log(err));
}

// Delete

let del = () => {

    if (!deleteValidation()) {
        alert("An ID is needed to carry out this operation.")
        return;
    }

    axios.delete(`http://localhost:8080/student/delete/${inputID.value}`)
        .then(res => {
            console.log(res.data);
            getAll();
        }).catch(err => console.log(err));
}


// EVENT LISTENERS
createBtn.addEventListener("click", create);
updateBtn.addEventListener("click", update);
deleteBtn.addEventListener("click", del);
getByIDBtn.addEventListener("click", getByID);
getByFirstNameBtn.addEventListener("click", getByFirstName);
getBySecondNameBtn.addEventListener("click", getBySecondName);
getByAgeBtn.addEventListener("click", getByAge);

// VALIDATION
// Get By ID


// Get By First Name


// Get By Second Name   


// Get By Age


// Create
let createValidation = () => {
    if (inputFirstName.value === "" || inputSecondName.value === ""
        || inputAge.value === "" || inputContactNumber.value === ""
        || inputEmail.value === "") {
        return false;
    } else {
        return true;
    }
}

// Update
let updateValidation = () => {
    if (inputID.value === "" || inputFirstName.value === "" || inputSecondName.value === ""
        || inputAge.value === "" || inputContactNumber.value === ""
        || inputEmail.value === "") {
        return false;
    } else {
        return true;
    }
}

// Delete
let deleteValidation = () => {
    if (inputID.value === "") {
        return false;
    } else {
        return true;
    }
}




