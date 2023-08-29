/*Es importante que el componente este declarado antes que 
la instancia de Vue*/
Vue.component('contador', {
    template: /*html */
        `
    <div>
        <h1>{{numero}}</h1>
        <button @click="numero++">Incrementar</button>
    </div>
`,
    data() {
        return {
            numero:0
        }
    }


})


