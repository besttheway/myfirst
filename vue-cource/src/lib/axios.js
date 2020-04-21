import axios from 'axios'
import baseURL from '@/config/index.js'
class HttpRequest {
  constructor (baseurl = baseURL) {
    this.baseUrl = baseurl
    this.queue = {}
  }

  getInsideConfig () {
    const config = {
      baseUrl: this.baseUrl,
      headers: {

      }
    }
    return config
  }

  interceptors (instance) {
    instance.interceptors.request.use(config => {
      // 添加全局的loading
      // Spin.show
      return config
    }, error => {
      return Promise.reject(error)
    })
    instance.interceptors.response.use(res => {
      console.log(res)
      return res
    }, error => {
      return Promise.reject(error)
    })
  }

  request (options) {
    const instance = axios.create()
    options = Object.assign(this.getInsideConfig, options)
    return instance(options)
  }
}
export default HttpRequest
