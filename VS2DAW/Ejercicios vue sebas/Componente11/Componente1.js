Vue.component('movie-card',{
    props:['image','title'],
    template:`
    <div>
        <img width="100px" v-bind:src="image" :alt="title"/>
        <h1>{{title}}</h1>
    </div>
    `
})


new Vue({
    el:'#app',
})