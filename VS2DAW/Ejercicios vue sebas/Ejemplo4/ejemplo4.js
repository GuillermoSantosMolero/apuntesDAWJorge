new Vue({
    el:'#app',
    data:{
        mensaje:"Hola Vue.js",
        imagen:"./azarquiel.jpeg",
        ver:true
    },
    methods:{
       toggleVer:function(){
        this.ver=!this.ver
       }
    }
})