/**
 * 模板模式示例
 */
// 命名空间 单体对象
var A = A || {};
//主体展示区容器
A.root = document.getElementById("container");
//创建视图方法集合
A.strategy = {
	'listPart'	: function(data){
		//模块容器
		var s = document.createElement("div"),
		//列表字符串
		ul = '',
		//列表数据
		ldata = data.data.li,
		//模块模板
		tpl = [
			 '<h2>{#h2#}</h2>',            
			 '<p>{#p#}</p>',            
			 '<ul>{#ul#}</ul>'
		].join(''),
		//列表项模板
		 liTpl = [            
			 '<li>',                
			 '<strong>{#strong#}</strong>',                
			 '<span>{#span#}</span>',            
			 '</li>'        
		].join('');
		data.id && (s.id == data.id);
		for(var i=0;len=ldata.length;i<len;i++){
			//如果有列表项数据
			if(ldata[i].em || ldata[i].span){
				 // 列表字符串追加一项列表项           
				ul += A.formateString(liTpl, ldata[i]);
			}
		}
		// 装饰列表数据   
		data.data.ul = ul;    
		// 渲染模块并插入模块中    
		s.innerHTML = A.formateString(tpl, data.data);    
		// 渲染模块    
		A.root.appendChild(s);
	}
}
//模板渲染方法
A.formateString = function(str,data){
	return str.replace(/\{#(\w+)#\}/g,function(match,key){return typeof data[key]===undefined?'':data[key]});
}

//模板生产器
A.view = function(name){
	// 模板库
	var v = {
		//代码模板
		code : '<pre><code>{#code#}</code></pre>',
		//图片模板
		img : '<img src="{#src#}" alt="{#alt#}" title="{#title#}" />',
		//带有id和类的模块模板
		part : '<div id="{#id#}" class="{#class#}">{#part#}</div>',
		//组合模板
		theme : [            
			 '<div>',                
			 '<h1>{#title#}</h1>',                
			 '{#content#}',            
			 '</div>'        
		].join('')
	}
	// 如果参数是一个数组，则返回多行模板
	if(Object.prototype.toString.call(name) == "[object Array]"){
		 // 模板缓存器
		var tpl;
		//遍历标识
		for(var i=0;i<name.length;i++){
			tpl += arguments.callee(name[i]);
		}
	}else{
		return v[name] ? v[name]:('<'+name+'>{#'+name+'#}</'+name+'>');
	}
	
}
