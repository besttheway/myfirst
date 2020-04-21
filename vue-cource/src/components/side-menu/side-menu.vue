<template>
  <div class="side-menu-wrapper">
    <slot></slot>
    <Menu v-show="!collapsed" width="auto" theme="dark" @on-select="handleSeclect">
      <template v-for="item in list">
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
    </Menu>
    <div v-show="collapsed" class="drop-wrapper">
      <template v-for="item in list">
        <side-menu-dropdown :showTitle="false" v-if="item.children" :name="item.name" :key="item.name" :parent="item">
        </side-menu-dropdown>
          <Tooltip v-else :content="item.title" placement="right" :name="item.name" :key="item.name">
            <span class="drop-menu-span" @click="handleClick(item.name)">
            <Icon :type="item.icon" :size="40"/>
            </span>
          </Tooltip>
      </template>
    </div>
  </div>
</template>

<script>
import reSubmenu from './re-submenu.vue'
import sideMenuDropdown from './side-menu-dropdown.vue'
export default {
  name: 'SideMenu',
  components: {
    reSubmenu,
    sideMenuDropdown
  },
  props: {
    collapsed: {
      type: Boolean,
      default: false
    },
    list: {
      type: Array,
      default: () => []
    }
  },
  mounted () {
    console.log(this.parent)
  },
  methods: {
    handleSeclect (name) {
      // 打印当前选中的name
      console.log(name)
    },
    handleClick (name) {
      // 打印当前选中的name
      console.log(name)
    }
  }
}
</script>

<style lang="less">
.side-menu-wrapper{
  width: 100%;
  .ivu-tooltip,.drop-menu-span{
    display: block;
    margin-top: 5px;
    width: 100%;
    text-align: center;
  }
}

</style>
