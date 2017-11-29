/*************************************************************************************************
***********************************财人汇网上开户项目*******************************************
**********************证书、控件相关js(对cairh-dev-pta.js进行了包装)*****************************
*************************************************************************************************/

/**
 * 获取控件版本信息
 * @return {TypeName} 
 */
function devGetVersion(){  
	devGetObject();
	var version = "";    
	try{   
		version = objEnroll.getVersion();
	}catch(e){
		return "error";
	}
	return version;
}

/**
 * 检测插件是否安装
 * @param {Object} activeXName
 * @param {Object} pluginName
 * @return {TypeName} 
 */
function devDetectPluginInstall(activeXName, pluginName){
    if (window.ActiveXObject || "ActiveXObject" in window){
        if (devDetectActiveX(activeXName)) {
            return true;
        }else{
            return false;
        }
    }else{
  		if(devDetectPlugin(pluginName)){
            return true;
        }else{
            return false;
        }
    }
}

/**
 * 检测插件是否安装(IE)
 * @param {Object} objectName
 * @return {TypeName} 
 */
function devDetectActiveX(objectName) {
    var obj = false;
    try {
        obj = new ActiveXObject(objectName);
    }catch (e) {
    }
    return obj;
}

/**
 * 检测插件是否安装（非IE）
 * @param {Object} pluginName
 * @return {TypeName} 
 */
function devDetectPlugin(pluginName){
    var length = navigator.plugins.length;
    for (var i = 0; i < length; i++) {
        var index = (navigator.plugins[i].name).indexOf(pluginName);
        if (index > -1) {
            return navigator.plugins[i];
        }
    }
    return false;
}

/**
 * 生成 object
 */
function devGetObject() {
	if (!document.getElementById('objEnroll')) {
		var oSpan = document.createElement("span");
    	document.body.appendChild(oSpan);
		
    	var enrollHtml = "";
	    if (B.ie) {
			enrollHtml = '<object id="objEnroll" classid="clsid:C0B91611-CBC0-403B-A482-5C587ACD4ADA" style="display:none"></object>';
	    } else {
			enrollHtml = '<embed id="objEnroll" type="application/crhsedit" width="0" height="0" />';
	    }
    	oSpan.innerHTML = enrollHtml;
	}
}

/**
 * 使用数字证书签名
 * @param {Object} orignContent
 * @param {Object} sn
 * @return {TypeName} 
 */
function devSignData(orignContent, sn){  
	return signSourceData(orignContent, sn);
}

/**
 * 生成证书请求字符串
 * @param {Object} type
 * @return {TypeName} 
 */
function devCreateCertReqStr(type){
	if(type == 1){
		//申请中登证书
		return createZDCSR();
	}else if(type == 2){
		//申请自建证书（天威）
		return createTWCSR();
	}else if(type == 3){
	    //申请自建证书（河南CA）
	    return createHNCSR();
	}
}

/**
 * 根据sn检查证书是否安装
 * @param {Object} sn
 * @return {TypeName} 
 */
function devDetectCert(sn){
	var cert = findCerts("", sn);
	if (!cert || cert.length == 0) {
		return false;
	}
	return true;
}

/**
 * 加密数据
 * @param {Object} content
 * @param {Object} encryptKey
 * @return {TypeName} 
 */
function devEncryptData(content, encryptKey){
	getObject();
	try{
		var retStr = objEnroll.cyhEncode(content, encryptKey);
		var array = retStr.split("|");
		return array[1];
	}catch(ex){
		return "error";
	}
}

/**
 * 获取MAC地址 
 * @return {TypeName} 
 */
function devGetMac(){  
	devGetObject();
	var myMac = "";    
	try{   
		myMac = objEnroll.getMac();
		if(null != myMac && myMac != ""){
			//获取第一个MAC地址
			var items = myMac.split(",");
			if(items.length > 0){
				myMac = items[0];
			}
		}
	}catch(e){
		return "error"
	}
	return myMac;
}

/**
 * MAC地址匹配，如果不匹配则弹出提示框
 * @param {Object} setupMac
 * @return {TypeName} 
 */
function devMacMatch(setupMac){
	if(!detectCairhInstall())return;
	
  	var localMacs = devGetMac();
  	var macthMacs = localMacs.split(",");
  	var length = macthMacs.length - 1;
  	var showFlag = true;
  	
	for(macIndex=0; macIndex<length; macIndex++){
    	var mac= macthMacs[macIndex];
    	if(setupMac.indexOf(mac) > -1){
      		showFlag = false;
      		break;
    	}
  	}
  	if(showFlag){
	    var dialog = new Dialog(undefined, {
			noClose: true,
	      	title: '提示',
	      	tipType: 'warn',
	      	message: '检测到您已经在另一台电脑上申请了数字证书，请使用上次申请数字证书的电脑完成网上开户操作',
	      	padding:'60px 80px' ,
	      	width:600,
	      	needDestroy: true
	    });
	}
}


/**
 * 检测天威控件是否安装
 * @return {TypeName} 
 */
function devDetectPTAInstall(){
    return devDetectPluginInstall("iTrusPTA.iTrusPTA", "iTrusPTA");
}

/**
 * 检测是否安装财人汇统一控件
 * 该控件包含财人汇基础控件包(密码,版本,加密等), 天威控件, ANYCHAT控件三部分)
 * ANYCHAT控件检测不在本方法执行
 * @return {TypeName} 
 */
function devDetectCairhInstall(){
	//检查财人汇基础控件包是否安装加载
	var version = devGetVersion();
	if(null == version || version == "" || version == "error"){
		return false;
	}
	//检查天威证书控件是否加载
	return devDetectPTAInstall();
}

/**
 * 检测是否安装财人汇控件，未安装则弹出安装提示框
 * @param 
 * @return true:已经安装 false:未安装，弹出层提示安装
 */
function devCheckCairhInstall() {
	if(!devDetectCairhInstall()) {
		devShowControlPkgInstallDialog();
		return false;
	} else {
		return true;
	}
	
}