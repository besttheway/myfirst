<template>
  <div class="box">
    <Card style="width:320px">
        <div style="text-align:center">
            <img :src="'data:image/png;base64,'+ action.bgImg" class="img">
            <h3>活动名称: {{ action.name }}</h3>
            <h3>开始时间: {{ action.startTime }}</h3>
            <h3>结束时间: {{ action.endTime }}</h3>
            <h3><Button type="success" @click="butClick">参与活动</Button></h3>
        </div>
    </Card>
    <Modal
        title="链接分享"
        :show-upload-list="false"
        v-model="imgUpload"
        class-name="vertical-center-modal">
        <p class="pcenter">请复制下方连接分享给其他人</p>
        <br>
        <p class="pcenter"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; {{ action.url }}</p>
    </Modal>
  </div>
</template>

<script>
import { getActionInfo, successShare } from '@/api/user'
export default {
  name: 'share',
  data () {
    return {
      action: '',
      imgUpload: false
    }
  },
  methods: {
    butClick () {
      successShare(this.action.id).then((res) => {
        if (res.data.code === 200) {
          this.imgUpload = true
          this.showSuccessMsg('参与活动成功')
        }
      })
    },
    showSuccessMsg (title, msg) {
      this.$Notice.success({
        title: title,
        desc: msg
      })
    }
  },
  mounted () {
    console.log(this.$route.params.url)
    getActionInfo(this.$route.params.url).then((res) => {
      if (res.data.code === 200) {
        this.action = res.data.data
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
