new Vue({
    el:'#app',
    template:` <div v-if="ver"> {{mensaje}}  
                <img :src="imagen" alt="" /> 
                </div> <button @click="toggleVer()">ver/ocultar</button>`,
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
