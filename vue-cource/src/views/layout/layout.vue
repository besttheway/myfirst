<template>
  <div class="layout-wrapper">
      <Layout class="layout-out">
        <Sider
        breakpoint="sm"
         collapsible hide-trigger
         v-model="iscollapsible">
         <side-menu :collapsed="iscollapsible" :list="menuList"></side-menu>
         </Sider>
      <Layout>
        <Header class="header-wrapper">
          <Icon @click.native="onShow" type="md-menu" size="32"/>
        </Header>
        <Content class="content-pad">
          <Card shadow class="page-card">
            <router-view/>
          </Card>
        </Content>
      </Layout>
      </Layout>
  </div>
</template>

<script>
import SideMenu from '_c/side-menu'
export default {
  data () {
    return {
      iscollapsible: false,
      menuList: [
        {
          name: 'menu1',
          title: '11111',
          icon: 'ios-leaf'
        },
        {
          title: 'bbbbug',
          name: 'menu2',
          icon: 'ios-leaf',
          children: [
            {
              title: '第二层1',
              icon: 'ios-leaf',
              name: 'menu21'
            },
            {
              title: '第二层2',
              icon: 'ios-lock',
              name: 'menu22',
              children: [
                {
                  title: '第三层1',
                  icon: 'ios-leaf',
                  name: 'menu221'
                },
                {
                  title: '第三层2',
                  icon: 'ios-leaf',
                  name: 'menu22'
                }
              ]
            }
          ]
        },
        {
          title: '33333',
          name: 'menu3',
          icon: 'ios-leaf'
        }
      ]
    }
  },
  methods: {
    onShow () {
      this.iscollapsible = !this.iscollapsible
    }
  },
  components: {
    SideMenu
  }
}
</script>

<style lang="less">
.layout-out, .layout-wrapper{
  height: 100%;
  .header-wrapper{
    background: #ffffff;
    box-shadow: 0 1px 1px rgba(0, 0, 0, 0.1);
    padding: 0px 20px;
  }
}
.content-pad{
  padding: 10px;
}
.page-card{
  min-height: ~"calc(100vh - 84px)";
}
</style>
