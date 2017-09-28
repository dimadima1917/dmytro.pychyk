import axios from 'axios';

const GET = 'GET';
const PUT = 'PUT';
const POST = 'POST';
const DELETE = 'DELETE';


const GET_ALL_PRODUCTS_URL = "http://localhost:8080/showAll";
const GET_ALL_5_MOST_POPULAR_URL = "http://localhost:8080/";


export const loadAllProductsRequest = () => {
    return axios({
        method: GET,
        url: GET_ALL_PRODUCTS_URL,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            "Access-Control-Allow-Origin": "*"
        },
        crossDomain: true,
        responseType: 'json'
    }).then(response => {
        return response.data
    })
};


export const load5MostPopular = () => {
    return axios({
        method: GET,
        url: GET_ALL_5_MOST_POPULAR_URL,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            "Access-Control-Allow-Origin": "*"
        },
        crossDomain: true,
        responseType: 'json'
    }).then(response => {
        return response.data
    })
};
