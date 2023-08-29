Vue.component('titulo',{
    template: /*html*/
    `
    <div>
        <h1>Numero {{numero}}</h1>
        <hijo></hijo>
    </div>
    `,
    computed:{
        ...Vuex.mapState(['numero'])
    },
})