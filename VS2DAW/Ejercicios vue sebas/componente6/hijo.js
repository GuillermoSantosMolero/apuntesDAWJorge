Vue.component('hijo', {
    
    template: /*html */
    `
     <div>
        <button @click="incrementar">+</button>
        <button @click="decrementar(2)">-</button>
        <h1>numero {{numero}}</h1>
     </div>
    `,
    computed: {
        ...Vuex.mapState(['numero'])
    },
    methods:{
        ...Vuex.mapMutations(['incrementar','decrementar'])
    }
})