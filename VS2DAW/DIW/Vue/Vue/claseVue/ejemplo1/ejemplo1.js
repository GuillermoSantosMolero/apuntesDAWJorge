new Vue({
    el:'#app',
    // template:`  <div v-if="ver">
    //                 {{mensaje}}
    //                 <img :src="imagen" :alt="mensaje">
    //             </div>
    //             <button @click="toggleVer()">ver/ocultar</button>
    //         `,
    template:'#ejemplo5',
    data:{
        mensaje:"Hola vue",
        imagen:"iconoaudi.jpg",
        ver:true
    },
    methods:{
        toggleVer(){
            this.ver=!this.ver
        }
    }
})