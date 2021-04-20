<template>
    <div>
        <b-col>
        <b-card 
        img-src="https://picsum.photos/600/300/?image#1073"
        img-alt="book"
        img-top
        tag="book"
        style="max-width:20rem"
        class="mb-7">
        <b-card-title>{{firstname}} {{lastname}}</b-card-title>
            <b-card-text>
                <h5>Opis autora:</h5>
                <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Provident nisi eaque reprehenderit veritatis accusamus fuga quod quas eveniet ex omnis.</p>
                
            </b-card-text>
                
                <b-button variant="primary" >Szczegóły</b-button>
    </b-card>
        </b-col>
    </div>
</template>
<script>


export default {
   props: ['authorid','firstname', 'books', 'lastname',],
   data(){
        return {
            author: [],
        };
    },
   author: {    
            "id": 'authorid',
            "firstName": "firstname",
            "lastName": "lastname",       
   },
   
}
</script>

<style lang="sccs" scoped>

</style>
