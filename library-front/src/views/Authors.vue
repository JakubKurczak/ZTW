<template>
  <b-container class="bv-example-row">
<b-row align-v="center">
    <book-card v-for="author in authors" :key="author.id" :authorid="author.id" :books="books" :firstname="author.firstName" :lastname="author.lastName"></book-card>
</b-row>
 
</b-container>
</template>

<script>
import Authors from '@/components/Authors.vue';
import axios from "axios";

export default {
  name: "Authors",
  components: {
    'book-card': Authors,
  },
    data(){
        return {
            authors:[],
            books:[],
        };
    },
    async created(){
        try{
            const res = await axios.get('http://localhost:8081/get/authors');
            const books = await axios.get('http://localhost:8081/get/books');
            
            this.authors = res.data;            
            this.books = books.data;
        }catch(e){
            console.error(e);
        }
    },
   
};
</script>
