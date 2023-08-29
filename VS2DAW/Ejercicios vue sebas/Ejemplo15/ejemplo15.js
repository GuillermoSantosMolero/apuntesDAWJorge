new Vue({
    el:'#app',
    data:{
       mensaje:"Welcome Toledo",
       contador:0,
    },
    computed:{
        invertir(){
            return this.mensaje.split('').reverse().join('');
        },
        color(){    
            return{
                'bg-success':this.contador <15,
                'bg-warning':this.contador >15,
                'bg-danger':this.contador >50
            }
        }
    }
})