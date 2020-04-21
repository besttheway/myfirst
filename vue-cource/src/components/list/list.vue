<template>
  <div>
    <ul>
      <li v-for="(item, index) in list" ：render="renderFunc" :key="index">
        <span v-if="!render">{{ item.name }}</span>
        <render-doc v-else :render-func="render" :name="item.name"></render-doc>
      </li>
    </ul>
  </div>
</template>

<script>
import renderDoc from '_c/render-dom'
export default {
  components: {
    renderDoc
  },
  props: {
    list: {
      type: Array,
      default: () => []
    },
    render: {
      type: Function,
      default: () => {}
    }
  },
  methods: {
    renderFunc (h) {
      return h('i', {

      })
    }
  }
}
</script>

<style>

</style>
