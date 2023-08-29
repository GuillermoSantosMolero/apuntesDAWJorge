<template>
    <div>
        <div class="m-1">
            <button class="btn" :value="mensaje" :class="classObject" @click="cambiaValor">{{mensaje}}</button>
        </div>
    </div>
</template>
<script>
    import {mapState,mapMutations} from'vuex';
    
    export default{
        name: 'Boton',
        props:{
            valor:{
                type:Number,
                default:0
            },
            mensaje:{
                type:String,
                default:'Click'
            },
            classObject:{
                type:String,
                default:''
            },
            activo:{
                type:Boolean,
                default:false
            }

        },
        computed:{
            ...mapState(['aleatorio'])
        },
        methods:{
            ...mapMutations(['sumarClick','restart','sumarPuntos']),
            cambiaValor(){
                this.sumarClick();
                this.valor=Math.floor(Math.random()*24)+1;
                if(this.mensaje=="Click"){
                    this.mensaje=this.valor;
                    this.activo=true;
                    if(this.valor==this.aleatorio){
                        this.classObject="btn-success";
                        this.restart();
                        this.sumarPuntos();
                    }else{
                        this.classObject="btn-danger";
                    }
                }
            },
        }
    } 
</script>