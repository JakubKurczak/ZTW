<template>
    <div>
    <b-form @submit="onSubmit" @reset="onReset" v-if="show">
      <b-form-group
        id="input-group-1"
        label="Tytuł:"
        label-for="input-1"
        
      >
        <b-form-input
          id="input-1"
          v-model="form.title"
          type="text"
          placeholder="Wpisz tytuł"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="Podaj ID autora" label-for="input-2">
        <b-form-input
          id="input-2"
          type="number"
          v-model="form.authorID"
          placeholder="Podaj ID autora"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-3" label="Liczba stron" label-for="input-3">
        <b-form-input
          id="input-3"
          type="number"
          v-model="form.pages"
          placeholder="Podaj liczbę stron"
          required
        ></b-form-input>
      </b-form-group>

      <b-button type="submit" variant="primary">Submit</b-button>
      <b-button type="reset" variant="danger">Reset</b-button>
    </b-form>
  
  </div>
</template>

<script>
import axios from "axios";

  export default {
    data() {
      return {
        form: {
          title: '',
          authorID: '',
          pages: '',
 
        },
       
        show: true
      }
    },
    methods: {
      onSubmit(event) {
        event.preventDefault()
        alert(JSON.stringify(this.form))
        axios.post('http://localhost:8081/create/book/'+this.form.title+'/'+this.form.authorID+'/'+this.form.pages);
      },
      onReset(event) {
        event.preventDefault()
        this.form.authorID = '';
        this.form.pages = '';
        this.form.title = '';
        this.show = false
        this.$nextTick(() => {
          this.show = true
        })
      }
    }
  }
</script>