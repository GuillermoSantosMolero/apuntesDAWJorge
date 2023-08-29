Vue.component('hijo',{
    template: /*html*/
    `
    <div>
        <button @click="incrementar">Incrementar</button>
        <button @click="decrementar(3)">Decrementar</button>
        <h1>Numero {{$store.state.numero}}</h1>
    </div>
    `,
    computed:{
        ...Vuex.mapState(['numero'])
    },
    methods:{
        ...Vuex.mapMutations(['incrementar','decrementar'])
    }
})