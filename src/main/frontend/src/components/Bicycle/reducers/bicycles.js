import * as types from '../actions/ActionTypes'

const initialState = {
    bicycles: [],
    isBicyclesLoading: false,
    bicyclesShouldBeReloaded: false
};

function bicyclesReducers(state = initialState, action) {
    switch (action.type) {
        case types.BICYCLES_LOADED: {
            return updateObject(state, {
                bicycles: action.bicycles,
                bicyclesShouldBeReloaded: false,
                isBicyclesLoading: false
            });
        }
        case types.BICYCLES_SHOULD_BE_RELOADED: {
            return updateObject(state, {
                bicyclesShouldBeReloaded: action.bicyclesShouldBeReloaded
                }
            )
        }
        case types.IS_BICYCLES_LOADING: {
            return updateObject(state, {
                isBicyclesLoading: action.isBicyclesLoading
            });
        }
        case types.DELETE_BICYCLE: {
            return updateObject(state, {
                bicyclesShouldBeReloaded:true
            })
        }
        default:
            return state;
    }

    function updateObject(obj, newProperties) {
        return Object.assign({}, obj, newProperties);
    }
}

export default bicyclesReducers;