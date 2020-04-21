<template>
  <Submenu :name="parent.name">
    <template slot="title">
      <Icon :type="parent.icon"/>
      {{ parent.title }}
    </template>
    <template v-for="item in parent.children">
        <re-submenu
          v-if="item.children"
          :key="item.name"
          :name="item.name"
          :parent="item"
          />
          <menu-item v-else :key="item.name" :name="item.name">
            <Icon :type="item.icon"/>
            {{ item.title }}
          </menu-item>
      </template>
  </Submenu>
</template>

<script>
export default {
  name: 'reSubmenu',
  props: {
    parent: {
      type: Object,
      default: () => ({})
    }
  }
}
</script>

<style>

</style>
