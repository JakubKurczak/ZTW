<template>
  <b-container class="bv-example-row">
<b-row align-v="center">
    <book-card v-for="book in filteredBooks" :key="book.id" :bookid="book.id" :booktitle="book.title" :author="book.author" :pages="book.pages" :isborrowed="book.borrowed"></book-card>
</b-row>
</b-container>
</template>

<script>
import Home from '@/components/Books.vue';
import axios from "axios";

export default {
  name: "Home",
  components: {
    'book-card': Home,
  },
 
    data(){
        return {
            books:[],
            displayBooks:[],
            search: '',
        };
    },
    async created(){
        try{
            const res = await axios.get('http://localhost:8081/get/books');
            this.books = res.data;
            this.displayBooks = res.data.slice(0, 3);
            this.rows = this.books.length;
        }catch(e){
            console.error(e);
        }
    },
    computed:{
      
      filteredBooks: function(){
        console.log(this.$store.search);
        return this.books.filter((book) => {
          return book.title.match(this.$store.search);
        })
      },
      
     
    },
    mounted() {
      this.search = this.$store.search;
    },
    
   
};
</script>
