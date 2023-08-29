<template>
    <div class="row">
        <button class="btn btn-primary" @click="comprobarDatos">Entrar</button>
    </div>
</template>

<script>
import {mapState,mapMutations} from 'vuex';
export default {
  name: 'Login',
  props: {
  },
  computed:{
      ...mapState(['nombre','pass','email','arrayUsuarios','mensaje']),
      
  },
  methods:{
      ...mapMutations(['cambiarValorNombre','cambiarValorMensaje']),
      comprobarDatos(){
          var nombreUsuario="";
          var coincide=false;
          for(var i=0; i<this.arrayUsuarios.length;i++){
              //alert("Entra al método comprobarDatos");
              var a=this.arrayUsuarios[i];
              if(a.email==this.email && a.password==this.pass){
                  coincide=true;
                  nombreUsuario=a.nombre;
              }
          }
          if(coincide){
              this.cambiarValorNombre(nombreUsuario);
              this.cambiarValorMensaje("");
          }else{
              this.cambiarValorNombre("");
              this.cambiarValorMensaje("Datos introducidos incorrectos");
          }
      }
  }
}
</script>
