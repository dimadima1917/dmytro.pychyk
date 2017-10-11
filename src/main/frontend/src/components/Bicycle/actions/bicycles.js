import * as types from './ActionTypes';
import {
    load5MostPopularBicyclesRequest,
    loadOfFoundBicyclesRequest,
    deleteBicycleRequest,
    createBicycleRequest
} from '../../../api/bikes';

export const bicyclesLoaded = (bicycles) => {
    return {
        type: types.BICYCLES_LOADED,
        bicycles
    }
};

export const bicyclesShouldBeReloaded = (bool) => {
    return {
        type: types.BICYCLES_SHOULD_BE_RELOADED,
        bicyclesShouldBeReloaded: bool
    }
};

export const isBicyclesLoading = (bool) => {
    return {
        type: types.IS_BICYCLES_LOADING,
        isBicyclesLoading: bool
    }
};

export const deletedBicycle = (bicycleID) => {
    return {
        type: types.DELETE_BICYCLE,
        bicycleID
    }
};

export const create = (bicycle, showNotifications) => {
    return {
        type: types.CREATE_BICYCLE,
        bicycle,
        showNotification: showNotifications
    }
};

export const loadFiveMostPopularBicycles = () => {
    return (dispatch, getState) => {
        if (getState().bicyclesReducers.isBicyclesLoading) {
            return Promise.resolve();
        }

        dispatch(isBicyclesLoading(true));

        return load5MostPopularBicyclesRequest()
            .then(bicycles => dispatch(bicyclesLoaded(bicycles)))
            .catch(e => console.error(e))
    }
};

export const loadOfFoundBicycles = (substring) => {
    return (dispatch, getState) => {
        if (getState().bicyclesReducers.isBicyclesLoading) {
            return Promise.resolve();
        }

        dispatch(isBicyclesLoading(true));

        return loadOfFoundBicyclesRequest(substring)
            .then(bicycles => dispatch(bicyclesLoaded(bicycles)))
            .catch(e => console.error(e))
    }
};

export const deleteBicycle = (bicycleID) => {
    return (dispatch) => {
        deleteBicycleRequest(bicycleID)
            .then(response => dispatch(deletedBicycle(bicycleID)))
            .then(response => dispatch(bicyclesShouldBeReloaded(true)))
            .catch(e => console.error(e))
    }
};

export const createBicycle = (bicycle) => {
    return (dispatch) => {
        createBicycleRequest(bicycle)
            .then(response => {
                if (response === -1) {
                    dispatch(create(bicycle, true))
                } else {
                    dispatch(create(bicycle, false))
                }
            })
            .then(response => dispatch(bicyclesShouldBeReloaded(true)))
            .catch(e => console.error(e))
    }
};

