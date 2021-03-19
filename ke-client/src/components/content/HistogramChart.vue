<template>
  <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
  <div :class="className" :style="{ height:height, width:width }"></div>
</template>

<script type="text/ecmascript-6">
import echarts from 'echarts'
require('echarts/theme/macarons') // echarts主题

export default {
  props: {
    // 以下为表格样式设置
    className: { type: String, default: 'line-chart' },
    width: { type: String, default: '100%' },
    height: { type: String, default: '360px' },
    // 以下为表格数据设置
    xAxisHdata: { type: Array, default: function () { return [] } },
    seriesHdata: { type: Array, default: function () { return [] } }
  },
  data () {
    return {
      chart: null
    }
  },
  mounted () {
    this.initChart()
  },
  beforeDestroy () {
    if (!this.chart) { return }
    this.chart.dispose()
    this.chart = null
  },
  watch: {
    titleText: { handler () { this.initChart() }, deep: true },
    xAxisHdata: { handler () { this.initChart() }, deep: true },
    seriesHdata: { handler () { this.initChart() }, deep: true }
  },
  methods: {
    initChart () {
      if (this.chart !== null && this.chart !== '' && this.chart !== undefined) {
        this.chart.dispose()
      }
      this.chart = echarts.init(this.$el, 'macarons')
      this.chart.setOption({
        xAxis: {
          type: 'category',
          data: this.xAxisHdata
        },
        yAxis: {
          type: 'value'
        },
        series: [{
          data: this.seriesHdata,
          type: 'bar',
          showBackground: true,
          backgroundStyle: {
            color: 'rgba(180, 180, 180, 0.2)'
          }
        }]
      })
    }
  }
}
</script>

<style lang="scss" type="text/scss" rel="stylesheet/scss" scoped>

</style>
