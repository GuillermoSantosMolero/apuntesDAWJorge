Vue.component('padre', {
    
    template: /*html */
    `
     <div class="p-5 bg-dark text-white">
        <h2>Componente padre: {{numeropadre}}</h2>
        <button class="btn btn-warning" @click="numeropadre++">Incrementar</button>
        <hijo numero="24"></hijo>
        {{nombrepadre}}
        <hijo v-bind:numero="numeropadre" @nombrehijo="nombrepadre=$event"></hijo>
     </div>
    `,
    data(){
        return{
            numeropadre:12,
            nombrepadre:''
        }
    }


})