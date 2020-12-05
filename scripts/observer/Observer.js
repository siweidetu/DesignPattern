/**
 * 观察者对象
 */
var Observer = (function(){
	// 防止消息队列暴漏而被篡改故将消息容器作为静态私有变量保存
	var __message = {};
	return {
		//注册信息接口
		//type:消息类型;fn对应处理动作
		regist:function(type,fn){
			 // 如果此消息不存在则应该创建一个该消息类型
			if(typeof(__message[type]=='undefined')){
				//将动作推入到该消息对应的动作执行队列中
				__message[type] = [fn];
			}else{
				 //将动作方法推入该消息对应的动作执行序列中
				__message[type].push(fn);
			}
		}
		//发布信息接口
		//type消息类型;args消息执行时需要的参数
		fire:function(type,args){
			if(!__message[type])return;
			//定义消息信息
			var events = {
				type = type,
				args = args || {}
			}
			//遍历消息动作
			var i = 0;
			var len = __message[type].length;
			for(;i<len;i++){
				// 依次执行注册的消息对应的动作序列
				__message[type][i].call(this,events);
			}
		}
		//移除信息接口
		remove:function(type,fn){
			if(__message[type] instanceof Array){
				var i = __message[type].length -1;
				for(;i>=0;i--){
					//如果存在该动作则在消息动作序列中移除相应动作
					__message[type][i] ===  fn && __messages[type].splice(i, 1);
				}
			}
		}
	}
})();

//测试
Observer.regist('test', function(e){ console.log(e.type, e.args.msg);});
Observer.fire('test', {msg: '传递参数'};
