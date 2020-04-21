<template>
  <div>
    login界面
    <br>
    <input type="text" v-model="username">
    <input type="password" v-model="password">
  </div>
</template>

<script>
export default {
  name: 'login_page',
  data () {
    return {
      passowrd: '',
      username: ''
    }
  }
}
</script>

<style>

</style>
