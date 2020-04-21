const BASE_URL = process.env.NODE_ENV === 'prodcution'
  ? '/'
  : '/'

const path = require('path')

const resolve = dir => path.join(__dirname, dir)

module.exports = {
  publicPath: BASE_URL,
  chainWebpack: conifg => {
    conifg.resolve.alias
      .set('@', resolve('src'))
      .set('_c', resolve('src/components'))
  },
  productionSourceMap: false,
  devServer: {
    proxy: 'http://localhost:10000'
  }
}
