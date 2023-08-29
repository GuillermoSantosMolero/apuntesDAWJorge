Vue.component('hijo',{
    template: /*html*/
    `
    <div class="">
        <button @click="incrementar">+</button>
        <button @click="decrementar(2)">-</button>
        <button @click="obtenerDatos">Cargar Datos</button>
        <h1>numero {{numero}}</h1>
        <ul v-for="(curso,index) in cursos" :key="index">
            <li>{{curso.nombre}}</li>
        </ul>
    </div>
    `,
    computed:{
        ...Vuex.mapState(['numero','cursos'])
    },
    methods:{
        ...Vuex.mapMutations(['incrementar','decrementar']),
        ...Vuex.mapActions(['obtenerDatos'])
    },
})