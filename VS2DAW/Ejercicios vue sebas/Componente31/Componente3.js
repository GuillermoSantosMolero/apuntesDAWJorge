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
            {nombre:"i.e.s azarquiel",url:"../azarquiel.jpeg"},
            {nombre:"cañada real",url:"../cañadareal.png"},
            {nombre:"sefarad", url:"../sefarad.jpeg"}
        ],
    },
    template:`
    
    <div>
    <school-card 
        v-for='(school, index) in schools'
        key='index'
        :title="school.nombre"
        :image="school.url">
    </school-card>
    </div>
    `,
})