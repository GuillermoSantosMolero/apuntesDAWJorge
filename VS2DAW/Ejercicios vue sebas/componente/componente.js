/*Es importante que el componente este declarado antes que 
la instancia de Vue*/
Vue.component('saludo', {
    template: /*html */
        `
    <div>
        <h1>Hola vue</h1>
        <h1>{{saludo}}
    </div>
`,
    data() {
        return {
            saludo: "Hola componente"
        }
    }
})


