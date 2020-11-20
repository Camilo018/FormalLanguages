class Services {

    constructor() {
        this.URL = 'http://localhost:9000/'
    }

    async addUser(user) {
        const response = await fetch(this.URL+'addCovid',{
            method: 'POST',
            body: user
        });

        const data = await response.json();
        console.log(data);
    }
}

export default Services;