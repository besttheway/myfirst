<template>
  <div class="box">
      <Card style="width:320px" v-for="item in actions" :key="item.id">
        <div style="text-align:center">
            <img :src="'data:image/png;base64,'+ item.bgImg" class="img">
            <p>活动名称: {{ item.name }}</p>
            <p>开始时间: {{ item.startTime }}</p>
            <p>结束时间: {{ item.endTime }}</p>
            <p>活动地址: {{ item.url }}</p>
            <p>已分享人数: {{ item.successed }}</p>
        </div>
    </Card>
  </div>
</template>

<script>
import { findAll } from '@/api/user'
export default {
  name: 'list',
  data () {
    return {
      actions: ''
    }
  },
  beforeMount () {
    findAll().then((res) => {
      if (res.data.code === 200) {
        this.actions = res.data.data
      }
    })
  }
}
</script>

<style>
.box {
  width:30%;
  margin:0 auto;
}
.img {
  width:60%;
}
.pcenter {
  margin:0 auto;
  width:50%;
}
</style>
