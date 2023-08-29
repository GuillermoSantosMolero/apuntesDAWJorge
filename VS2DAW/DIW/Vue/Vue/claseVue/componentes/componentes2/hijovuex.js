Vue.component('hijo',{
    template: /*html*/
    `
    <div>
        <button @click="$store.commit('incrementar')">Incrementar</button>
        <h1>Numero {{$store.state.numero}}</h1>
    </div>
    `,
})