new Vue({
    el:'#app',
   template:'#ejemplo6',
    data:{
        mensaje:"Hola Vue.js",
        imagen:"./azarquiel.jpeg",
        ver:true,
    },
    methods:{
       toggleVer:function(){
        this.ver=!this.ver
       }
    },
})                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
