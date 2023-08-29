import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    arrayUsuarios:[{nombre:"Ana Navarro",password:"123456",email:"anan@gmail.com"}],
    email:"",
    pass:"",
    nombre:"",
    mensaje:"",
  },
  mutations: {
    cambiarValorNombre(state, nombreParam){
      state.nombre=nombreParam;
    },
    cambiarValorMensaje(state, mensajeError){
      state.mensaje=mensajeError;
    }
  },
  actions: {
  },
  modules: {
  }
})