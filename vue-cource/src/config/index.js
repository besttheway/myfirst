const baseURL = process.env.NODE_ENV === 'prodcution'
  ? '/'
  : 'http://localhost:9998'

export default baseURL
