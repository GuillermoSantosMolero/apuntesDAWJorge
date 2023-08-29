<template>
  <div id="app">
    <Panel></Panel>
  </div>
</template>

<script>
import Panel from './components/Panel.vue';
export default {
  name: 'App',
  components: {
    Panel,
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
