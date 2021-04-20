import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    search:'',
  },
  mutations: {
    changeName (state, searchvalue) {
      state.search = searchvalue;
      console.log(state.search);
   }
  },
  actions: {},
  modules: {},
  getters:{
    search: state => {
     return state.search;
   }
  },
});
