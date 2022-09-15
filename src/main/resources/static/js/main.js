"use strict";

// SELECTORS

// DIVS
let resultDiv = document.querySelector("#result-div");

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
// Printing Table To Screen
let databaseResults = (result) => {
    let entryDiv = document.createElement("div");
    entryDiv.setAttribute("class", "entry-div");

    let entryPrint = document.createElement("div");
    entryPrint.setAttribute("class", "entry-print");
    entryPrint.textContent = `${result.id} || ${result.firstName} || ${result.secondName} 
    || ${result.age} || ${result.contactNumber} || ${result.email}`;

    let fillForm = document.createElement("button");
    fillForm.textContent = "Fill Form";
    fillForm.type = "button";
    fillForm.setAttribute("Class", "btn btn-danger btn-sm")
    fillForm.setAttribute("onClick", `formFiller(${result.id})`);

    entryDiv.appendChild(entryPrint);
    entryDiv.appendChild(fillForm);
    resultDiv.appendChild(entryDiv);
}

//Fill Form
let formFiller = (id) => {
    axios.get(`http://localhost:8080/student/getById/${id}`)
        .then(response => {
            let res = response.data;
            inputID.value = res.id;
            inputFirstName.value = res.firstName;
            inputSecondName.value = res.secondName;
            inputAge.value = res.age;
            inputContactNumber.value = res.contactNumber;
            inputEmail.value = res.email;
        }).catch(err => console.log(err));
}

// Get All
let getAll = () => {
    axios.get("http://localhost:8080/student/getAll")
        .then(res => {
            resultDiv.innerHTML = "";
            let results = res.data;

            for (let result of results) {
                databaseResults(result);
            }
        }).catch(err => console.log(err));
}

// Get By ID
let getByID = () => {

    if (!idValidation()) {
        alert("An ID needs to be entered.")
        return;
    }

    axios.get(`http://localhost:8080/student/getById/${inputID.value}`)
        .then(res => {
            resultDiv.innerHTML = "";
            let results = res.data;

            for (let result of results) {
                databaseResults(result);
            }
        }).catch(err => console.log(err));
}

// Get By First Name
let getByFirstName = () => {

    if (!firstNameValidation()) {
        alert("A first name needs to be entered.")
        return;
    }

    axios.get(`http://localhost:8080/student/getByFirstName/${inputFirstName.value}`)
        .then(res => {
            resultDiv.innerHTML = "";
            let results = res.data;

            for (let result of results) {
                databaseResults(result);
            }
        }).catch(err => console.log(err));
}

// Get Second Name
let getBySecondName = () => {

    if (!secondNameValidation()) {
        alert("A second name needs to be entered.")
        return;
    }

    axios.get(`http://localhost:8080/student/getBySecondName/${inputSecondName.value}`)
        .then(res => {
            resultDiv.innerHTML = "";
            let results = res.data;

            for (let result of results) {
                databaseResults(result);
            }
        }).catch(err => console.log(err));
}

// Get By Age
let getByAge = () => {

    if (!ageValidation()) {
        alert("An age needs to be entered.")
        return;
    }

    axios.get(`http://localhost:8080/student/getByAge/${inputAge.value}`)
        .then(res => {
            resultDiv.innerHTML = "";
            let results = res.data;

            for (let result of results) {
                databaseResults(result);
            }
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
let idValidation = () => {
    if (inputID.value === "") {
        return false;
    } else {
        return true;
    }
}

// Get By First Name
let firstNameValidation = () => {
    if (inputFirstName.value === "") {
        return false;
    } else {
        return true;
    }
}

// Get By Second Name   
let secondNameValidation = () => {
    if (inputSecondName.value === "") {
        return false;
    } else {
        return true;
    }
}

// Get By Age
let ageValidation = () => {
    if (inputAge.value === "") {
        return false;
    } else {
        return true;
    }
}

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
    if (inputID.value === "" && inputFirstName.value === "" || inputSecondName.value === ""
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




