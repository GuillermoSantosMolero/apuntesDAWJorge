new Vue({
    el:'#app',
    data:{
        mensaje:"RELACIÓN DE IES",
        schools:[
            {nombre:"Azarquiel",alumnos:1800},
            {nombre:"Sefarad",alumnos:600},
            {nombre:"Virrey Morcillo",alumnos:650}
        ],
        newschool:'',
        totalAlumnos:'',
    },
    methods:{
        addSchool(){
            this.schools.push({
                nombre: this.newschool, alumnos: 0,
            });
            this.newschool='';
        },
        addNumero(index){
            this.schools[index].alumnos++;
        },
        undoNumero(index){
            if(this.schools[index].alumnos>0){
                this.schools[index].alumnos--;
            }
        }
    },
    computed:{
        CalculaTotal(){
            this.totalAlumnos=0;
            for(school of this.schools){
                this.totalAlumnos+=school.alumnos;
            }
            return this.totalAlumnos;
        }
    }
})