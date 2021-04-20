<template>
  <b-container class="bv-example-row">

    <add-book></add-book>

</b-container>
</template>

<script>
import AddBook from '@/components/AddBook.vue';
import axios from "axios";

export default {
  name: "AddBook",
  components: {
    'add-book': AddBook,
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
