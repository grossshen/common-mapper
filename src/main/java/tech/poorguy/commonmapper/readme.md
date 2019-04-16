项目描述：联系web项目后台编写
使用技术：通用mapper，注解生成格式化返回内容
规则：
    1. 路径规则：
        * 路径是区分大小写的，项目中不使用大写
        * 如果是接口服务，路径最前面加/api用来区分
        * get,post,put,delete分别对应select,insert,update,delete尽量不在路径中使用动词
        * 路径中的多个单词使用“-”连接，如user/health-status
    2. 参数规则：
        * MediaType：也叫做MIME类型，在Http协议消息头中使用Content-Type来表示具体请求中的媒体类型信息
            * POST,PUT,PATCH等使用application/json，将参数放在请求体中以json传至服务器
            * GET,DELETE使用默认类型application/x-www-form-urlencoded
        * 路径参数：对应于@PathVariable注解，注意如果路径参数中有"."，"."后面的内容会被舍弃
        * 请求头参数：对应于@RequestHeader注解，会放token，api版本等，可以写拦截器校验header中的参数
        * 请求体参数：分为URL请求查询参数（@RequestParam）和请求体参数（@RequestBody）
    3. 返回规则
        无效数据不返回，必要数据返回：所有值为null的字段不做返回，对于添加（POST）、修改（PUT | PATCH）这类方法我们需要立即返回添加或更新后的数据以备前端使用（这是一个约定需要遵守）。