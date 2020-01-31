import Vue from 'vue';
import Router from 'vue-router';
import Hello from '../components/Customer';
Vue.use(Router);


export default new Router({
    mode: "history",
    base: process.env.BASE_URL,
    routes:[
        {
            path:"/",
            name:"hello",
            component: Hello
        }
    ]
});