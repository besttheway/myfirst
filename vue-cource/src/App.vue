<template>
  <div id="app">
    <router-link :to="{ name: 'list' }">点击跳转list</router-link>
    <router-view/>
  </div>
</template>

<style lang="less">
html,body {
  height: 100%;
}
body{
  margin: 0px;
}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  // text-align: center;
  color: #2c3e50;
  height: 100%;
}

#nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
</style>
