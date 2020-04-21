<template>
  <div class="split-pane-con">
    <div class="pane pane-left"></div>
    <div>aaa</div>
    <div class="pane pane-right"></div>
  </div>
</template>

<script>
export default {

}
</script>

<style lang="less">
.split-pane-con {
  width: 100%;
  height: 100%;
  position: relative;
  .pane {
    position: absolute;
    height: 100%;
    &-left {
      background: palevioletred;
    }
    &-right {
      background: palegoldenrod;
    }
  }
}
</style>
