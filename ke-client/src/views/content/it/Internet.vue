<template>
  <div class = "internet-content">
    <h3 class="internet-content-title">IT互联网课程监控</h3>
    <div class="internet-content-select">
      <div class="internet-content-select-module">
        <span>课程模块</span>
        <el-select v-model="initValue" placeholder="请选择">
          <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
      </div>
      <div class="internet-content-select-time">
        <span>时间范围</span>
        <el-radio v-model="radioTime" label="1">近一周</el-radio>
        <el-radio v-model="radioTime" label="2">近一月</el-radio>
        <el-radio v-model="radioTime" label="3">近一年</el-radio>
      </div>
      <div class="internet-content-select-category">
        <span>类别</span>
        <el-radio v-model="radioCategory" label="1">购买数</el-radio>
        <el-radio v-model="radioCategory" label="2">浏览数</el-radio>
      </div>
    </div>
    <div class="internet-content-display">

    </div>
  </div>
</template>

<script type="text/ecmascript-6">
export default {
  name: 'Internet',
  data () {
    return {
      options: [],
      initValue: '',
      selectFlag: false,
      radioTime: '1',
      radioCategory: '1'
    }
  }
}
</script>

<style lang="scss" type="text/scss" rel="stylesheet/scss" scoped>
  .internet-content{
    .internet-content-title{
      text-align: center;
      font-size: 20px;
      line-height: 40px;
      height: 40px;
      margin: 0;
      background-color: #a1cdc9;
    }
    .internet-content-select{
      margin: 10px 20px;
      .internet-content-select-module{
        display: inline-block;
        width: 30%;
        text-align: center;
        span{
          margin-right: 15px;
          font-weight: 700;
        }
      }
      .internet-content-select-time{
        display: inline-block;
        width: 40%;
        text-align: center;
        span{
          margin-right: 15px;
          font-weight: 700;
        }
      }
      .internet-content-select-category{
        display: inline-block;
        width: 30%;
        text-align: center;
        span{
          margin-right: 15px;
          font-weight: 700;
        }
      }
    }
  }

</style>
