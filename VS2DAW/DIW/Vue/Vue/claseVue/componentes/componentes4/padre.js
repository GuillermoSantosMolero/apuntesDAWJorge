Vue.component('titulo',{
    template: /*html*/
    `
    <div>
        <h1>Nombre {{nombre}}</h1>
        <h1>Numero {{numero}}</h1>
        <button @click="$store.commit('decrementar')">Decrementar</button>
        <hijo></hijo>
    </div>
    `,
    computed:{
        ...Vuex.mapState(['numero','nombre'])
    },
})