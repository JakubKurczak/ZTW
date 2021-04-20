<template>
    <div>
  <b-navbar toggleable="lg" type="dark" variant="info">
    <b-navbar-brand href="/">Wypożyczalnia książek</b-navbar-brand>

    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

    <b-collapse id="nav-collapse" is-nav>
      <b-navbar-nav>
        <b-nav-item href="/autorzy">Autorzy</b-nav-item>
         <b-nav-item href="/ksiazki">Książki</b-nav-item>
         <b-nav-item href="/dodaj">Dodaj książkę</b-nav-item>
       
      </b-navbar-nav>
      <b-navbar-nav class="ml-auto">
        <b-nav-form>
          <b-form-input size="sm" class="mr-sm-2" placeholder="Wyszukaj" v-model="searchval"></b-form-input>
          <b-button size="sm" class="my-2 my-sm-0" v-on:click="search">Wyszukaj</b-button>
        </b-nav-form>

        <b-nav-item-dropdown text="Język" right>
          <b-dropdown-item href="#">EN</b-dropdown-item>
          <b-dropdown-item href="#">ES</b-dropdown-item>
          <b-dropdown-item href="#">RU</b-dropdown-item>
          <b-dropdown-item href="#">FA</b-dropdown-item>
        </b-nav-item-dropdown>

        
      </b-navbar-nav>
    </b-collapse>
  </b-navbar>
</div>
</template>
<script>

export default {
    data(){
        return{
            searchval:'',            
        }
    },
    methods: {
        search: function (event) {
            if(event)
                this.$store.commit("changeName", this.searchval);
        },
    }   
    
}
</script>

<style lang="sccs" scoped>
    
</style>
