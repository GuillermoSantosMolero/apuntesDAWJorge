Vue.component('hijo', {
    
    template: /*html */
    `
     <div>
        <button @click="$store.commit('incrementar')">+</button>
        <h1>numero {{$store.state.numero}}</h1>
     </div>
    `,
})