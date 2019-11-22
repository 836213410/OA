//是否操作成功
function isOprSuccess(data){
	var oprSucc = 'IS000000';
	var oprSuccQuiet = "NS000000";
    return (data.resCode == oprSucc || data.resCode == oprSuccQuiet)
}

/**
 * 系统响应提示框 编码格式:弹出框类别(1位, E:异常,W:警告,I:信息,N:无) + 响应信息类型(1位) + 组件标识(3位) + 错误编号(3位)
 * 举例:
 *    EP000000, 弹出异常框, 错误类型是参数异常 
 *    W0000000, 弹出警告框 
 *    I0000000, 弹出信息框 
 *    N0000000, 不弹出任何提示框
 * fn为点击确定之后的回调函数
 */
function sysResAlert(data, fn) {
	
	// 响应码必须6位, 不为8位, 返回
	if (data.resCode.length != 8) {
		return;
	}

	// 如果第一位是N, 不弹出任务提示框, 返回
	var alertTypeCode = data.resCode.substring(0, 1);
	if ("N" == alertTypeCode.toUpperCase()) {
		return;
	}

	var alertType = ""; // 信息框的类型
	var alertTitle = ""; // 弹出窗口的标题
	var resInfoColor = ""; // 响应信息字体的颜色

	// 如果第一位是E, 弹出框的类型为错误
	if ("I" == alertTypeCode.toUpperCase()) {
		alertType = "info";
		alertTitle = "提示";
		resInfoColor = "blue";
	}
	// 如果第一位是W, 弹出框的类型为警告
	else if ("W" == alertTypeCode.toUpperCase()) {
		alertType = "warning";
		alertTitle = "警告";
		resInfoColor = "orange";
	}
	// 其它为异常型警告框
	else {
		alertType = "error";
		alertTitle = "异常";
		resInfoColor = "red";

		// 第二位是异常种类
		var exceptionType = data.resCode.substring(1, 2);
		// Business Exception
		if ('B' == exceptionType.toUpperCase()) {
			alertTitle = "业务" + alertTitle
		}
		// Parameter Exception
		else if ('P' == exceptionType.toUpperCase()) {
			alertTitle = "参数" + alertTitle
		}
		// Right Exception
		else if ('R' == exceptionType.toUpperCase()) {
			alertTitle = "权限" + alertTitle
		}
	}

	// 拼装消息
	var alertMsg = "";
	alertMsg = "<table style='width:100%;'>";
	alertMsg += "<tr>";
	alertMsg += "<td style='text-align:right; width:60px'>" + "响应码: " + "</td>";
	alertMsg += "<td style='color:" + resInfoColor + ";'>" + data.resCode + "</td>";
	alertMsg += "<tr>";
	alertMsg += "<tr>";
	alertMsg += "<td style='text-align:right; vertical-align:top;width:60px;'>" + "响应信息: " + "</td>";
	alertMsg += "<td style='color:" + resInfoColor + ";'>" + data.resMsg + "</td>";
	alertMsg += "<tr>";
	alertMsg += "</table>";

	// 显示Alert框
	alert(alertTitle, alertMsg, alertType, fn);
}