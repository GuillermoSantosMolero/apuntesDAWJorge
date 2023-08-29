Vue.component('hijo',{
    template: /*html*/
    `
    <div class="p-5 bg-success">
        <h2>Componente hijo</h2>
        <h2>{{numero}}</h2>
        <!--<h2>{{nombre}}</h2>-->
    </div>
    `,
    props:['numero'],
    data(){
        return{
            nombre:"Pablo"
        }
    },
    mounted(){
        this.$emit('nombrehijo',this.nombre);
    },
})