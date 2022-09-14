<script lang="ts">
interface Contact {
    Name:String,
    Number:Number,
}
export default {
    data(){return {
        hidden:true,
    }},
    props:{
        contactIn:Object,
    }
}
</script>
<template>
    <div @mouseover="hidden=false" @mouseleave="hidden=true" id="container">
        <h1>{{contactIn.Name}}</h1>
        <h3 v-if="contactIn.Number">Number: {{contactIn.Number}}</h3>
        <h3 v-if="contactIn.Address">Address: {{contactIn.Address}}</h3>
        <div id="button" v-if="!hidden">
            <img src="../assets/delete.svg"/>
        </div>
    </div>
</template>
<style scoped>
    #container {
        border: solid;
        border-radius: 10px;
        margin: 5px;
    }
    h1, h3 {
        margin: 5px;
    }
    h1{
        text-align: center;
    }
    #button {
        display: relative;
        left:175px;
        top:-40px;
    }
</style>