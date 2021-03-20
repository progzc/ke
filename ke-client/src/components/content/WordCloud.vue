<template>
  <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
  <div :class="className" :style="{ height:height, width:width }"></div>
</template>

<script type="text/ecmascript-6">
import echarts from 'echarts'
import 'echarts-wordcloud' // 词云
require('echarts/theme/macarons') // echarts主题

export default {
  name: 'WordCloud',
  props: {
    // 以下为表格样式设置
    className: { type: String, default: 'line-chart' },
    width: { type: String, default: '100%' },
    height: { type: String, default: '500px' },
    // 以下为词云数据设置
    wordClouds: { type: Array, default: function () { return [] } }
  },
  data () {
    return { chart: null }
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
    wordClouds: { handler () { this.initChart() }, deep: true }
  },
  methods: {
    initChart () {
      if (this.chart !== null && this.chart !== '' && this.chart !== undefined) {
        this.chart.dispose()
      }
      this.chart = echarts.init(this.$el, 'macarons')
      this.chart.setOption({
        series: [{
          type: 'wordCloud',
          shape: 'circle',
          // shape: 'rectangle',
          // maskImage: maskImage,
          left: 'center',
          top: 'center',
          width: '80%',
          height: '80%',
          right: null,
          bottom: null,
          sizeRange: [10, 75],
          rotationRange: [-90, 90],
          rotationStep: 35,
          gridSize: 15,
          drawOutOfBound: false,
          layoutAnimation: true,
          textStyle: {
            fontFamily: 'sans-serif',
            fontWeight: 'normal',
            color: function () {
              return 'rgb(' + [
                Math.round(Math.random() * 160),
                Math.round(Math.random() * 160),
                Math.round(Math.random() * 160)
              ].join(',') + ')'
            }
          },
          emphasis: {
            focus: 'self',
            textStyle: {
              shadowBlur: 10,
              shadowColor: '#333'
            }
          },
          data: this.wordClouds
        }]
      })
    }
  }
}
</script>

<style lang="scss" type="text/scss" rel="stylesheet/scss" scoped>

</style>
