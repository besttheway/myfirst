<template>
  <Dropdown placement="right-start">
    <span class="drop-menu-span">
      <Icon v-if="showIcon" :type="parent.icon"  :size="40"></Icon>
      <!-- <span v-if="showTitle"> {{ parent.title }}</span> -->
      <DropdownItem v-if="showTitle" :style="titleStyle">
          {{ parent.title }}
      </DropdownItem>
    </span>
    <DropdownMenu slot="list">
      <template v-for="item in parent.children">
        <side-menu-dropdown :showIcon="false" v-if="item.children" :key="item.name" :parent="item"/>
        <DropdownItem v-else :key="item.name" :name="item.name">
            {{ item.title }}
        </DropdownItem>
      </template>
    </DropdownMenu>
  </Dropdown>
</template>

<script>
export default {
  name: 'sideMenuDropdown',
  props: {
    parent: {
      type: Object,
      default: () => ({})
    },
    showIcon: {
      type: Boolean,
      default: true
    },
    showTitle: {
      type: Boolean,
      default: true
    }
  },
  computed: {
    titleStyle () {
      return {
        textAlign: this.showTitle ? 'left' : 'center'
      }
    }
  }
}
</script>

<style>
.ivu-tooltip,.drop-menu-span{
    display: block;
    margin-top: 5px;
    width: 100%;
    text-align: center;
  }
.drop-wrapper > .ivu-dropdown{
  display:block;
}
</style>
