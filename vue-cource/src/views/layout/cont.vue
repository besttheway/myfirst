<template>
  <div class="home">
    <Row>
      <i-col></i-col>
    </Row>
    <Row :gutter="10">
      <i-col span="12"></i-col>
      <i-col span="12"></i-col>
    </Row>
    <Row :gutter="10" class="blur">
      <i-col :lg="6" :md="4"></i-col>
      <i-col :lg="6" :md="4"></i-col>
      <i-col :lg="6" :md="4"></i-col>
      <i-col :lg="6" :md="4"></i-col>
    </Row>
  </div>
</template>

<script>
export default {

}
</script>

<style lang="less">
.home{
  .ivu-col{
    height: 50px;
    background: pink;
    margin-top: 10px;
    background-clip: content-box;
  }
}
.blur{
  .ivu-col{
    background: blue;
    background-clip: content-box;
  }
}
</style>
