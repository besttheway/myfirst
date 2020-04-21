
export default [
  {
    path: '/',
    name: 'Home',
    component: () => import('@/views/layout/layout.vue')
  },
  {
    path: '/list',
    name: 'list',
    component: () => import('@/views/list.vue')
  },
  {
    path: '/*',
    component: () => import('@/views/error/error_404.vue')
  }
]
