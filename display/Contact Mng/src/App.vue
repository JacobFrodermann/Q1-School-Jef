<script lang="ts">
import Contact from "./components/Contact.vue";

interface Contact {
  Name:String,
  Number:Number,
}

  export default {
    data() {
        return {
            Contacts: [{ Name: "Max  Mustermann", Number: 123456 }]
        };
    },
    components: { Contact }
}
</script>

<template>
  <h1>Kontakte</h1>
  <ul>
    <li v-for="contact in Contacts"><Contact :contactIn="contact"></Contact></li>
  </ul>
</template>

<style scoped>
  ul{
    list-style: none;
  }
</style>
