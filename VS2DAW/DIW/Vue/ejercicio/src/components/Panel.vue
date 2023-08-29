<template>
    <div @click="final">
        <div class="row m-1">
            <label>Aleatorio: {{aleatorio}}</label>
            <label>Puntos: {{puntos}}</label>
            <label>Fallos: {{fallos}}</label>
        </div>
        <div :class="juego">
            <div class="row m-1">
                <Boton></Boton>
                <Boton></Boton>
                <Boton></Boton>
                <Boton></Boton>
                <Boton></Boton>
                <Boton></Boton>
            </div>
            <div class="row m-1">
                <Boton></Boton>
                <Boton></Boton>
                <Boton></Boton>
                <Boton></Boton>
                <Boton></Boton>
                <Boton></Boton>
            </div>
            <div class="row m-1">
                <Boton></Boton>
                <Boton></Boton>
                <Boton></Boton>
                <Boton></Boton>
                <Boton></Boton>
                <Boton></Boton>
            </div>
            <div class="row m-1">
                <Boton></Boton>
                <Boton></Boton>
                <Boton></Boton>
                <Boton></Boton>
                <Boton></Boton>
                <Boton></Boton>
            </div>
        </div>
        <div :class="finJuego">
            <div class="row m-10">
                <div class="col-12"><p class="display-1">¡Fin del juego!</p></div>
                <div class="col-12"><p class="display-5">¡Has llegado al número máximos de errores!</p></div>
                <div class="col-12"><a href="http://localhost:8080/"><p class="display-5">Jugar otra vez</p></a></div>
            </div>
        </div>
    </div>
</template>
<script>
import Boton from './Boton.vue';
import {mapState} from 'vuex';
    export default{
       name: 'Panel',
       props:{
           juego:{
               type:String,
               default:''
           },
           finJuego:{
               type:String,
               default:'invisible'
           }
       },
       computed:{
             ...mapState(['aleatorio','puntos','fallos'])
        },
        components: {
            Boton,
        },
        methods:{
            final(){
                if(this.fallos==4){
                    this.juego="invisible";
                    this.finJuego="visible";
                }
            }
        }
    }
    
</script>
<style>
.visible{
    visibility: visible;
}
.invisible{
    visibility: hidden;
}
</style>