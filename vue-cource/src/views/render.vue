<template>
  <div>
    <list :list="list" :render="renderFunc"></list>
  </div>
</template>

<script>
import list from '_c/list'
export default {
  name: 'render',
  data () {
    return {
      list: [
        'miao',
        'xue'
      ]
    }
  },
  components: {
    list
  },
  methods: {
    handleClick (event) {
      console.log(event)
    },
    renderFunc (h, name) {
      return h('i', {
        sytle: {
          color: 'pink'
        }
      }, name)
    }
  }
}
</script>

<style>

</style>
