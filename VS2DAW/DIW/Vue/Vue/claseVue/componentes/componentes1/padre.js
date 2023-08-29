Vue.component('padre',{
    template: /*html*/
    `
    <div class="p-5 bg-dark text-white">
        <h2>Componente Padre: {{numeropadre}}</h2>
        <button @click="numeropadre++">Incrementar</button>
        <button @click="numeropadre--">Decrementar</button>
        {{nombrepadre}}
        <hijo v-bind:numero="numeropadre" @nombrehijo="nombrepadre=$event"></hijo>
    </div>
    `,
    data(){
        return{
            numeropadre:12,
            nombrepadre:""
        }
    }
})