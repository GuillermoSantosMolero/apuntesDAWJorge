import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    aleatorio: Math.floor(Math.random()*24)+1,
    puntos:0,
    fallos:0,
  },
  mutations: {
    sumarClick(state){
      state.fallos++;
    },
    sumarPuntos(state){
      state.puntos+=5;
    },
    restart(state){
      state.fallos=0;
    }
  },
  actions: {
  },
  modules: {
  }
})