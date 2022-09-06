<script lang="ts">
import Contact from "./components/Contact.vue";

interface ContactOb {
  Name:String,
  Number:Number,
  Address:String,
}

var id = 0;

  export default {
    data() {
        return {
            Contacts: [{ Name: "Max  Mustermann", Number: 123456 , Address:"Am Schloß 19",id:id++},{ Name: "Max  Mustermann", Address:"",Number: 123456 , id:id++}],
            new:false,
            name:"",
            number:"",
            nddress:"",
        };
    },
    components: { Contact },
    methods: {
      Create(){
        this.Contacts.push({ Name: this.name, Number: this.number, Address: this.address, id: id++});
        this.name = "";
        this.number = "";
        this.address = "";
        this.new = false;
      }
    }
}
</script>

<template>
  <h1>Kontakte</h1>
  <ul>
    <li v-for="contact in Contacts" :key="contact.id">
       <Contact :contactIn="contact"/>
    </li>
    <li v-if="!New"><img src="./assets/New.svg" width="100" @click="this.new = true;"/></li>
  </ul>


  <div id="new" v-if="new">
    <label for="Name">Name:</label>
    <input id="Name" v-model="name"/>


    <label for="Number">Number:</label>
    <input id="Number" v-model="this.number"/>

    <label for="Address">Adresse:</label>
    <input id="Address:" v-model="address"/><br/>
    <button @click="Create()">Erstellen</button>
  </div>
</template>

<style scoped>
  ul{
    list-style: none;
  }
  li{
    float: left;
  }
  h1{
        text-align: center;
        font-size: 50px;
        margin-bottom: 100px;
    }
  #new{
    border-radius: 25px;
    background-color: rgba(210,210,210,.95);
    position: absolute;
    top: 100%;
    left: 10%;
    width: 80%;
    height: 800%;
    text-align: center;
  }
  #new input{
    background-color: rgba(0,0,0,0);
    margin: 75px;
    width:200px;
    height: 35px;
  }
  #new label{
    margin-left: 20px;
    font-size: 25px;
  }
  #new button{
    margin: 100px;
    text-align: center;
    font-size: 35px;
  }
</style>
