import request from 'network/request'

export function executeGetSysMenuNav () {
  return request({
    url: '/sys/menu/nav',
    method: 'get'
  })
}
