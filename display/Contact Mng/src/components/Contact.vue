<script lang="ts">
interface Contact {
    Name:String,
    Number:Number,
}
export default {
    props:{
        contactIn:Object,
    }
}
</script>
<template>
    <div>
        <h1>{{contact.Name}}</h1>
        <h3>Number: {{contact.Number}}</h3>
    </div>
</template>
<style scoped>
    div {
        border: solid;
        border-radius: 10px;
    }
</style>