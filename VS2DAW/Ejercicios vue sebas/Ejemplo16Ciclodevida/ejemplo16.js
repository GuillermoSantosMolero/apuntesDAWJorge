var vm=new Vue({
    el:'#app',
    data:{
       mensaje:"Tema ciclo de vida"
    },
    /*Antes de este hook aún no se ha creado el componenete
    sólo se ha creado la instancia de vue, por lo que no podemos
    acceder a las propiedades de nuestro componente */
    beforeCreate() {
        console.log('beforeCreated')
    },
    /*En el hook created es el momento adecuado para acceder a
    una api externa*/
    created() {
        console.log('created')
    },
    beforeMount() {
        console.log('beforeMount')
    },
    
     /*En el hook created es el momento adecuado para acceder a
    una api externa desde la que podemos incorporar un conjunto de datos*/
    mounted() {
        console.log('mounted')
    },
    beforeUpdate() {
        console.log('beforeMounte')
    },
    updated() {
        console.log('updated')
    },
    beforeMount() {
        console.log('beforeMount')
    },
    mounted() {
        console.log('mounted')
    },
    beforeDestroy() {
        console.log('beforeDestroy')
    },
    destroyed() {
        console.log('destroyed')
    },
    methods:{
        destruir(){
            this.$destroy();
        }
    }
})