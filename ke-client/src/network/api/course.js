import request from 'network/request'

export function executeGetDisplayLineChart (selVal, radioTime, radioCategory) {
  return request({
    url: '/sys/course/chart',
    method: 'get',
    params: {
      id: selVal,
      count: radioTime,
      category: radioCategory
    }
  })
}
