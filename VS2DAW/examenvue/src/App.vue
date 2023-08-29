<template>
  <div id="app" class="container">
    <div class="row m-2">
      <div class="col-2">
        <button class="btn btn-success" @click="verRegistro">Registrarse</button>
      </div>
      <div class="col-1">
        <button class="btn btn-primary" @click="verLogin">Login</button>
      </div>
    </div>
    <div class="row m-2">
      <div class="col-4">
        <div class="row m-2">
          <label>Nombre:</label><input type="text" v-model="$store.state.nombre">
        </div>
        <div class="row m-2">
          <label>Email:</label><input type="text" v-model="$store.state.email">
        </div>
        <div class="row m-2">
          <label>Contraseña:</label><input type="text" v-model="$store.state.pass">
        </div>
      </div>
    </div>
    <div class="row m-2">
      <div class="col-2" :class="registromostrar">
        <Registro></Registro>
      </div>
      <div class="col-1" :class="loginmostrar">
        <Login></Login>
      </div>
    </div>
    <div class="row m-2">
      <label>{{$store.state.mensaje}}</label>
    </div>
  </div>
</template>

<script>
import Login from './components/Login.vue'
import Registro from './components/Registro.vue'
import {mapMutations} from 'vuex';
export default {
  name: 'App',
  props:{
    loginmostrar:{
      type: String,
      value:'',
    },
    registromostrar:{
      type: String,
      value:'nover',
    },
  },
  components: {
    Login,
    Registro
  },
  methods:{
    ...mapMutations(['cambiarValorMensaje']),
    verRegistro(){
      this.cambiarValorMensaje("");
      this.loginmostrar="nover";
      this.registromostrar="ver";
    },
    verLogin(){
      this.cambiarValorMensaje("");
      this.loginmostrar="ver";
      this.registromostrar="nover";
    }
  }
}
</script>
<style scoped>
  .nover{
    display: none;
  }
  .ver{
    display: inline;
  }
</style>

