import axios from 'axios';

const GET = 'GET';
const PUT = 'PUT';
const POST = 'POST';
const DELETE = 'DELETE';
const GET_FOUND_BICYCLES_URL = "http://localhost:8080/searchBySubstring/";
const GET_5_MOST_POPULAR_BICYCLES_URL = "http://localhost:8080/top5";
const CREATE_BICYCLE_URL = "http://localhost:8080/create";
const DELETE_BICYCLE_URL = "http://localhost:8080/delete/";

export const load5MostPopularBicyclesRequest = () => {
    return axios.get(GET_5_MOST_POPULAR_BICYCLES_URL)
        .then(response => {
            return response.data
        })
};

export const loadOfFoundBicyclesRequest = (substring) => {
    return axios.get(GET_FOUND_BICYCLES_URL.concat(substring))
        .then(response => {
            return response.data
        })
};

export const createBicycleRequest = (bicycle) => {
    return axios.post(CREATE_BICYCLE_URL, bicycle).then(response => {
        return response.data
    })
};

export const deleteBicycleRequest = (bicyclesId) => {
    return axios.delete(DELETE_BICYCLE_URL.concat(bicyclesId)).then(response => {
        return response.data
    })
};
