<template>
  <div class = "internet-content">
    <h3 class="internet-content-title">IT互联网课程监控</h3>
    <div class="internet-content-select">
      <div class="internet-content-select-module">
        <span>课程模块</span>
        <el-select v-model="initValue" placeholder="请选择" @change="currentSel">
          <el-option
            v-for="item in options"
            :key="item.id"
            :label="item.name"
            :value="item.id">
          </el-option>
        </el-select>
      </div>
      <div class="internet-content-select-time">
        <span>时间范围</span>
        <el-radio-group v-model="radioTime" @change="currentTime">
          <el-radio v-model="radioTime" label="7">近一周</el-radio>
          <el-radio v-model="radioTime" label="30">近一月</el-radio>
          <el-radio v-model="radioTime" label="365">近一年</el-radio>
        </el-radio-group>
      </div>
      <div class="internet-content-select-category">
        <span>类别</span>
        <el-radio-group v-model="radioCategory" @change="currentCategory">
          <el-radio label="1">购买数</el-radio>
          <el-radio label="2">浏览数</el-radio>
        </el-radio-group>
      </div>
    </div>
    <div class="internet-content-display" v-if="initValue">
      <line-chart :legend="legend" :series="series"></line-chart>
    </div>
    <div class="internet-content-display">
      <histogram-chart :xAxisHdata="xAxisHdata" :seriesHdata="seriesHdata"></histogram-chart>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
import LineChart from 'components/content/LineChart'
import HistogramChart from 'components/content/HistogramChart'

import { executeGetCourseModule } from 'network/api/internet'
import {
  executeGetDisplayLineChart,
  executeGetDisplayHistogramChart
} from 'network/api/course'

export default {
  name: 'Internet',
  components: {
    'line-chart': LineChart,
    'histogram-chart': HistogramChart
  },
  data () {
    return {
      menuId: 1,
      options: [],
      initValue: null,
      selVal: '',
      selectFlag: false,
      radioTime: '7',
      radioCategory: '1',
      legend: '',
      series: [],
      xAxisHdata: [],
      seriesHdata: []
    }
  },
  created () {
    this.getCourseModule(this.menuId)
  },
  mounted () {
    if (this.initValue) {
      this.displayLineChart(this.selVal, this.radioTime, this.radioCategory)
    } else {
      this.displayHistogramChart(this.menuId, this.radioTime, this.radioCategory)
    }
  },
  methods: {
    getCourseModule (menuId) {
      executeGetCourseModule(menuId).then(data => {
        if (data && data.code === 200) {
          this.options = data.options
        } else {
          this.$message.error(data.msg)
        }
      })
    },
    displayLineChart (selVal, radioTime, radioCategory) {
      executeGetDisplayLineChart(selVal, radioTime, radioCategory).then(data => {
        if (data && data.code === 200) {
          this.legend = data.legend
          this.series = data.series
        } else {
          this.$message.error(data.msg)
        }
      })
    },
    displayHistogramChart (menuId, radioTime, radioCategory) {
      executeGetDisplayHistogramChart(menuId, radioTime, radioCategory).then(data => {
        if (data && data.code === 200) {
          this.xAxisHdata = data.xAxisHdata
          this.seriesHdata = data.seriesHdata
        } else {
          this.$message.error(data.msg)
        }
      })
    },
    currentSel (selVal) {
      this.selVal = selVal
      this.displayLineChart(this.selVal, this.radioTime, this.radioCategory)
      this.displayHistogramChart(this.menuId, this.radioTime, this.radioCategory)
    },

    currentCategory () {
      this.displayLineChart(this.selVal, this.radioTime, this.radioCategory)
      this.displayHistogramChart(this.menuId, this.radioTime, this.radioCategory)
    },

    currentTime () {
      this.displayLineChart(this.selVal, this.radioTime, this.radioCategory)
      this.displayHistogramChart(this.menuId, this.radioTime, this.radioCategory)
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
