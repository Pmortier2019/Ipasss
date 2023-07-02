let localhost = 'http://localhost:8080/';
export default class LoginService {
    token = '...'


    isLoggedIn() {
        if (window.sessionStorage.getItem("myJWT")) return true;
        else return false;
    }

    login(username, password) {
        let bodyCredentials = {username, password}

        if (username === "" || password === "") {
            return alert("je hebt geen inloggegevens ingevuld")
        }

        return fetch('restservices/login', {
            method: 'POST',
            body: JSON.stringify(bodyCredentials),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(r => {
            return r.json()
        }).then(j => {
            window.sessionStorage.setItem("myJWT", myJson.JWT);
        }).catch(() => alert("geen juiste inloggegevens ingevuld"))
    }



    getUser() {
        return Promise.resolve(true);
    }

    logout() {
        return Promise.resolve(window.sessionStorage.clear())
    }
}