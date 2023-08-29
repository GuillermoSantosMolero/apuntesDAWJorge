<template>
    <button class="btn btn-success" @click="registrarUsuario">Registrar</button>
</template>
<script>
import {mapState,mapMutations} from 'vuex';
export default {
  name: 'Registro',
  props: {
  },
  computed:{
      ...mapState(['nombre','pass','email','arrayUsuarios']),
  },
  methods:{
      ...mapMutations(['cambiarValorMensaje']),
      comprobarSiExiste(){
          var coincide=false;
          for(var i=0; i<this.arrayUsuarios.length;i++){
              var a=this.arrayUsuarios[i];
              if(a.email==this.email){
                  coincide=true;
              }
          }
        return coincide;
      },
      registrarUsuario(){
          if(!this.comprobarSiExiste()){
              //alert("No existe")
              this.arrayUsuarios.push({
                  nombre:this.nombre,
                  password:this.pass,
                  email:this.email
              });
              this.cambiarValorMensaje("Se ha guardado el nuevo usuario correctamente");
          }else{
              this.cambiarValorMensaje("No pueden existir dos usuarios con el mismo correo");
          }
      }
  }
}
</script>