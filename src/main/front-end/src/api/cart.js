import axios from 'axios';

const GET_ALL_PRODUCTS = "http://localhost:8080/";

export const loadAllProducts = () => {
    return axios({
        method: 'GET',
        url: GET_ALL_PRODUCTS,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            "Access-Control-Allow-Origin": "*"

        },
        crossDomain: true,
        responseType: 'json'
    }).then(response => response.data)
};