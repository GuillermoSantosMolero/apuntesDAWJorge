Vue.component('hijo', {
    
    template: /*html */
    `
     <div class="py-5 bg-success">
        <h2>Componente hijo </h2>
        <h2>{{numero}}</h2>
     </div>
    `,
    props:['numero']


})