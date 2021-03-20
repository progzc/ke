<template>
  <div class = "home-content">
    <h3 class = "home-content-title">全站监控统计系统</h3>
    <div class = "home-content-select">
      <div class="home-content-select-time">
        <span>时间范围</span>
        <el-radio-group v-model="radioTime" @change="currentTime">
          <el-radio label="7">近一周</el-radio>
          <el-radio label="30">近一月</el-radio>
          <el-radio label="365">近一年</el-radio>
        </el-radio-group>
      </div>
      <div class = "home-content-select-category">
        <span>类别</span>
        <el-radio-group v-model="radioCategory" @change="currentCategory">
          <el-radio label="1">购买数</el-radio>
          <el-radio label="2">浏览数</el-radio>
        </el-radio-group>
      </div>
      <div class = "home-content-word-cloud">
        <word-cloud :wordClouds="wordClouds"></word-cloud>
      </div>
    </div>

  </div>

</template>

<script type="text/ecmascript-6">
import WordCloud from 'components/content/WordCloud'
import { executeGetDisplayWordCloud } from 'network/api/home'

export default {
  name: 'home',
  components: {
    'word-cloud': WordCloud
  },
  data () {
    return {
      radioTime: '7',
      radioCategory: '1',
      wordClouds: []
    }
  },
  created () {
  },
  mounted () {
    this.displayWordCloud(this.radioTime, this.radioCategory)
  },
  methods: {
    displayWordCloud (radioTime, radioCategory) {
      executeGetDisplayWordCloud(radioTime, radioCategory).then(data => {
        if (data && data.code === 200) {
          console.log(data.wordClouds)
          this.wordClouds = data.wordClouds
        } else {
          this.$message.error(data.msg)
        }
      })
    },
    currentTime () {
      this.displayWordCloud(this.radioTime, this.radioCategory)
    },
    currentCategory () {
      this.displayWordCloud(this.radioTime, this.radioCategory)
    }
  }
}
</script>

<style lang="scss" type="text/scss" rel="stylesheet/scss" scoped>
  .home-content{
    .home-content-title{
      text-align: center;
      font-size: 20px;
      line-height: 40px;
      height: 40px;
      margin: 0;
      background-color: #a1cdc9;
    }
    .home-content-select{
      margin: 20px 20px;
      .home-content-select-time{
        display: inline-block;
        width: 50%;
        text-align: center;
        span{
          margin-right: 15px;
          font-weight: 700;
        }
      }
      .home-content-select-category{
        display: inline-block;
        width: 50%;
        text-align: center;
        span{
          margin-right: 15px;
          font-weight: 700;
        }
      }
    }
  }
</style>
