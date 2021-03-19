import request from 'network/request'

export function executeGetDisplayLineChart (selVal, radioTime, radioCategory) {
  return request({
    url: '/sys/course/lineChart',
    method: 'get',
    params: {
      id: selVal,
      count: radioTime,
      category: radioCategory
    }
  })
}

export function executeGetDisplayHistogramChart (menuId, radioTime, radioCategory) {
  return request({
    url: '/sys/course/histogramChart',
    method: 'get',
    params: {
      menuId: menuId,
      count: radioTime,
      category: radioCategory
    }
  })
}
