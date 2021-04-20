import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Authors from "../views/Authors.vue";
import AddBook from "../views/AddBook.vue";
Vue.use(VueRouter);

const routes = [
  {
    path: "/ksiazki",
    name: "Home",
    component: Home,
  },
  {
    path: "/about",
    name: "About",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/About.vue"),
  },
  {
    path: "/autorzy",
    name: "Autors",
    component: Authors,
  },
  {
    path: "/dodaj",
    name: "DodajKsiazke",
    component: AddBook,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
