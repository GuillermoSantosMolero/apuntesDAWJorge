Vue.component('titulo', {
    
    template: /*html */
    `
        <div>
        <button @click="$store.commit('decrementar')">-</button> 
        <h1>numero {{numero}}</h1>
         <hijo></hijo>
        </div>
    `,
    computed: {
        numero(){
            return store.state.numero
        }
    },
    


})