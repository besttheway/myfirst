import Vue from 'vue'
import VueRouter from 'vue-router'
import routes from './router'
import iView from 'iview'

Vue.use(VueRouter)

const router = new VueRouter({
  routes
})

// const LOGINED = true

router.beforeEach((to, from, next) => {
  // next({ name: 'split-pane' })
})

router.afterEach((to, from, next) => {
  iView.LoadingBar.finish()
})

export default router
