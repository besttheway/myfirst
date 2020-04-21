import axios from './index'

export const getUserInfo = (action) => {
  return axios.request({
    url: '/insertAction',
    method: 'post',
    data: action
  })
}

export const getActionInfo = (param) => {
  return axios.request({
    url: '/getInfo',
    method: 'get',
    params: {
      url: param
    }
  })
}

export const successShare = (param) => {
  return axios.request({
    url: '/successShare',
    method: 'get',
    params: {
      id: param
    }
  })
}

export const findAll = (param) => {
  return axios.request({
    url: '/findAll',
    method: 'get'
  })
}
