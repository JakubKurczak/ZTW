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
        <b-card-title>{{booktitle}}</b-card-title>
            <b-card-text>
                <p>Id: {{bookid}}</p>
                <p v-if="author != null">Autor: {{ author.firstName}} {{author.lastName}}</p>
                <p v-else>Autor: Nieznany</p>
                <p>Strony: {{pages}}</p>
                <p v-if="isborrowed">Czy Wypożyczona: Tak</p>
                <p v-else>Czy Wypożyczona: Nie</p>
            </b-card-text>
                <b-button v-if="isborrowed" variant="primary" disabled>Wypożycz</b-button>
                <b-button v-else variant="primary" v-on:click="borrow">Wypożycz</b-button>
                <b-button variant="primary" v-on:click="usun">Usuń</b-button>
    </b-card>
        </b-col>
    </div>
</template>
<script>
import axios from "axios";

export default {
   props: ['booktitle', 'bookid', 'author', 'pages', 'isborrowed'],
   methods: {
    borrow: function (event) {
        if(event)
            axios.put('http://localhost:8081/update/user/book/borrow/2/'+this.bookid);
        },
   
    usun: function(event){
        if(event)
            axios.delete('http://localhost:8081/delete/book/'+this.bookid);
      },
      }
}

</script>

<style lang="sccs" scoped>

</style>
