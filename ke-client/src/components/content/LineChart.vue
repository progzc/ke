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
    height: { type: String, default: '220px' },
    // 以下为表格数据设置
    titleText: { type: String, default: '' },
    legend: { type: Array, default: function () { return [] } },
    series: { type: Array, default: function () { return [] } }
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
    legendData: { handler () { this.initChart() }, deep: true },
    series: { handler () { this.initChart() }, deep: true }
  },
  methods: {
    initChart () {
      if (this.chart !== null && this.chart !== '' && this.chart !== undefined) {
        this.chart.dispose()
      }
      this.chart = echarts.init(this.$el, 'macarons')
      this.chart.setOption({
        title: { text: this.titleText }, // 表格标题
        tooltip: { trigger: 'axis' },
        legend: { data: this.legend }, // 图例名称
        grid: { left: '3%', right: '4%', bottom: '3%', containLabel: true },
        xAxis: { type: 'category', boundaryGap: false },
        yAxis: { type: 'value', boundaryGap: true },
        series: this.series
      })
    }
  }
}
</script>

<style lang="scss" type="text/scss" rel="stylesheet/scss" scoped>

</style>
