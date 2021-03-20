import request from 'network/request'

export function executeGetDisplayWordCloud (radioTime, radioCategory) {
  return request({
    url: '/sys/course/wordCloud',
    method: 'get',
    params: {
      count: radioTime,
      category: radioCategory
    }
  }, false)
}
