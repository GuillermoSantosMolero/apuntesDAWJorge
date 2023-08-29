new Vue({
    el:'#app',
   template:'#ejemplo7',
    data:{
        mensaje:"Hola Vue.js",
        imagen:"./azarquiel.jpeg",
        ver:true,
        cursos:[
            {nombre:"bootstrap",url:"la url"},
            {nombre:"sass", url:"url sass"},
            {nombre:"vue",url:"url vue"},
        ],
    },
    methods:{
       toggleVer:function(){
        this.ver=!this.ver
       }
    },
})                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
