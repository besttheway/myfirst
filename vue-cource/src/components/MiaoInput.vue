<template>
    <div>
      <input @input="handleInput" type="text" :value="str">
    </div>
</template>

<script>
export default {
  name: 'MiaoInput',
  props: {
    str: String
  },
  methods: {
    handleInput(event) {
      const value = event.target.value;
      this.$emit('input', value);
    }
  }
}
</script>

<style>

</style>
