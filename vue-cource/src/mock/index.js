import Mock from 'mockjs'
import { getUserInfo } from './response/user'
const Random = Mock.Random
Mock.mock(/\/getUserInfo/, 'get', getUserInfo)

Mock.setup({
  timeout: 0
})

Random.extend({
  fruit () {
    const fruit = ['apple', 'peach', 'lemon']
    return this.pick(fruit)
  }
})
export default Mock
