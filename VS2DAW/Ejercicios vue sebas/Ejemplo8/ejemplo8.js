new Vue({
    el:'#app',
    data:{
        mensaje:"Relación de IES",
        schools:[
            {nombre:'Azarquiel', alumnos:1800},
            {nombre:'Sefarad',alumnos:600},
            {nombre:'Virrey Morcillo',alumnos:650}
        ],
        newschool:'',
    },
    methods: {
        addSchool(){
            this.schools.push({
                nombre:this.newschool, alumnos:0,
            });
         this.newschool='';   
        }
    },
})