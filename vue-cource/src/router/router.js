
export default [
  {
    path: '/',
    name: 'Home',
    component: () => import('@/views/layout/layout.vue'),
    children: [
      {
        path: 'home',
        name: 'woxiwangkandaode',
        component: () => import('@/views/layout/cont.vue')
      }
    ]
  },
  {
    path: '/share/:url',
    component: () => import('@/views/share.vue')
  },
  {
    path: '/login',
    component: () => import('@/views/login.vue')
  },
  {
    path: '/managera',
    component: () => import('@/views/manager.vue')
  },
  {
    path: '/list',
    component: () => import('@/views/list.vue')
  },
  {
    path: '/split-pane',
    name: 'split-pane',
    component: () => import('@/views/split-pane.vue')
  },
  {
    path: '/render',
    component: () => import('@/views/render.vue')
  },
  {
    path: '/menu_page',
    name: 'menu_page',
    component: () => import('@/views/menu_page.vue')
  },
  {
    path: '/error',
    name: 'error_404',
    component: () => import('@/views/error/error_404.vue')
  },
  {
    path: '/*',
    component: () => import('@/views/error/error_404.vue')
  }
]
