Vue.component('school-card',{
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
    data:{
        schools:[
            {nombre:"azarquiel",url:"../azarquiel.jpeg"},
            {nombre:"cañada real",url:"../cañadareal.png"},
            {nombre:"sefarad", url:"../sefarad.jpeg"}
        ],
    },
})