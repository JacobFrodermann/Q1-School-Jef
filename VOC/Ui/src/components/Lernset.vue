<script lang="ts">
    export default {
        props: {
            Name: String,
            Index: String,
        }
    }
</script>

<template>
    <div id="main">
        <h1>{{Name}}</h1>
        <h3>{{Index}} Vocabs</h3>
    </div>
</template>

<style scoped>
    #main {
        border-radius: 5px;
        border-style: solid;
        overflow: hidden;
    }
    #main h1 {
        font-size: 30px;
        margin: 8px;
        padding-right: 80px;
    }
    #main h3 {
        font-size: 22px;
        margin: 5px;
    }
</style>
