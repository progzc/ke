import request from 'network/request'

export function executeGetCourseModule (id) {
  return request({
    url: `/sys/menu/module/${id}`,
    method: 'get'
  })
}
