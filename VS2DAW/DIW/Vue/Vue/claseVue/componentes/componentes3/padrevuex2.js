Vue.component('titulo',{
    template: /*html*/
    `
    <div>
        <h1>Numero {{numero}}</h1>
        <button @click="$store.commit('decrementar')">Decrementar</button>
        <hijo></hijo>
    </div>
    `,
    computed:{
        numero(){
            return store.state.numero
        }
    },
})