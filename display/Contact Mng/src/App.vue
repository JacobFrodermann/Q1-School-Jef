<script lang="ts">
import Contact from "./components/Contact.vue";

interface ContactOb {
  Name:String,
  Number:Number,
}

var id = 0;

  export default {
    data() {
        return {
            Contacts: [{ Name: "Max  Mustermann", Number: 123456 , id:id++}]
        };
    },
    components: { Contact }
}
</script>

<template>
  <h1>Kontakte</h1>
  <ul>
    <li v-for="contact in Contacts" :key="contact.id">
       <p>test</p>
       <Contact :contactIn="contact"/>
    </li>
  </ul>
</template>

<style scoped>
  ul{
    list-style: none;
  }
</style>
