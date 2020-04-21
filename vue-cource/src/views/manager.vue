<template>
  <div style="margin:0 auto;width:30%">
    <Form ref="formValidate" :model="formValidate" :rules="ruleValidate" :label-width="80">
        <FormItem label="活动名称" prop="name">
            <Input v-model="formValidate.name" placeholder="请输入活动名称"/></Input>
        </FormItem>
        <FormItem label="分享人数" prop="successPeople">
            <InputNumber style="width:100%" v-model="formValidate.successPeople" :min="1"></InputNumber>
        </FormItem>
        <FormItem label="时间" prop="date">
<DatePicker :value="formValidate.date" @on-change='handleChange' format="yyyy/MM/dd" type="daterange" placement="bottom-end" placeholder="活动开始/结束时间"></DatePicker>
        </FormItem>

        <FormItem>
            <Button type="primary" @click="handleSubmit('formValidate')">Submit</Button>
            <Button @click="handleReset('formValidate')" style="margin-left: 8px">Reset</Button>
        </FormItem>
    </Form>
    <Modal
        ref="upload"
        title="Title"
        :show-upload-list="false"
        v-model="imgUpload"
        class-name="vertical-center-modal" :closable="false">
          <Upload action="/uploadFile" style="margin:0 auto;width:40%" :data="action" >
            <Button icon="ios-cloud-upload-outline">上传活动背景图片</Button>
          </Upload>
    </Modal>
  </div>
</template>

<script>
import { getUserInfo } from '@/api/user.js'
export default {
  data () {
    return {
      formValidate: {
        name: '',
        successPeople: '',
        date: [],
        img: ''
      },
      action: {},
      formItems: [],
      imgUpload: false,
      ruleValidate: {
        name: [
          { required: true, message: '活动名称不能为空', trigger: 'blur' }
        ],
        date: [
          { required: true, type: 'date', message: '请选择时间', trigger: 'change' }
        ]
      }
    }
  },
  methods: {
    handleSubmit (name) {
      if (this.formValidate.name.length < 1) {
        this.showErrorMsg('活动名称不能为空')
        return false
      }
      if (typeof this.formValidate.successPeople !== 'number' && this.formValidate.successPeople < 1) {
        this.showErrorMsg('分享人数不能为空且必须大于零')
        return false
      }
      if (this.formValidate.date.length < 2) {
        this.showErrorMsg('活动时间不能为空')
        return false
      }
      this.formValidate.startTime = new Date(this.formValidate.date[0])
      this.formValidate.endTime = new Date(this.formValidate.date[1])
      getUserInfo(this.formValidate).then(res => {
        console.log(res.data.code)
        if (res.data.code === 200) {
          this.showSuccessMsg('活动生成成功啦', '活动地址是:' + res.data.data.url)
          this.imgUpload = true
          this.action = res.data.data
          this.action.startTime = new Date(this.action.startTime)
          this.action.endTime = new Date(this.action.endTime)
        }
      })
    },
    handleReset (name) {
      this.$refs[name].resetFields()
    },
    handleChange (date) {
      this.formValidate.date = date
    },
    showErrorMsg (str) {
      this.$Notice.error({
        title: str
      })
    },
    showSuccessMsg (title, msg) {
      this.$Notice.success({
        title: title,
        desc: msg
      })
    },
    showImgUpload () {
      this.imgUpload = true
    }
  }
}
</script>
