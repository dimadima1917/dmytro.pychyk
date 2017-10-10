import {applyMiddleware, combineReducers, createStore} from 'redux';
import thunk from 'redux-thunk';
import {createLogger} from 'redux-logger'

import bicyclesReducers from './components/Bicycle/reducers/bicycles';

const middleware = [thunk, createLogger()];

const store = createStore(
    combineReducers({
        bicyclesReducers: bicyclesReducers
    }),
    applyMiddleware(...middleware)
);

export default store;