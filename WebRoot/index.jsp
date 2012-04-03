<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript">
	function RC4(Key, Data) {
		var KeyBytes = new Array(255);
		var CypherBytes = new Array(255);
		for (i = 0; i < 256; ++i) {
			KeyBytes[i] = Key.charCodeAt(i % Key.length);
			CypherBytes[i] = i;
		}
		var Jump = 0;
		for (i = 0; i < 256; ++i) {
			Jump = (Jump + CypherBytes[i] + KeyBytes[i]) & 0xFF;
			Tmp = CypherBytes[i]; // Swap:
			CypherBytes[i] = CypherBytes[Jump];
			CypherBytes[Jump] = Tmp;
		}
		i = 0;
		Jump = 0;
		var Result = "";
		for (X = 0; X < Data.length; ++X) {
			i = (i + 1) & 0xFF;
			Tmp = CypherBytes[i];
			Jump = (Jump + Tmp) & 0xFF;
			T = (Tmp + CypherBytes[Jump]) & 0xFF;
			CypherBytes[i] = CypherBytes[Jump]; // Swap:
			CypherBytes[Jump] = Tmp;
			Result += String.fromCharCode(Data.charCodeAt(X) ^ CypherBytes[T]); // Character Encryption
		}
		
		return Result;
	}

	function Data2ASCIIhex(S) {
		var Result = "";
		var Chars = "0123456789ABCDEF"
		for (i = 0; i < S.length; ++i) {
			Byte = S.charCodeAt(i);
			lo = Byte & 0x0F;
			hi = Byte >> 4;
			Result += Chars.charAt(hi) + Chars.charAt(lo);
		}
		return Data2ASCIIhex(Result);
	}

	function encrypt() {

		var plaintxt = document.getElementById("plaintxt").value;
		var result = RC4("hwlchinafdsfdsfds", plaintxt);
		document.getElementById("result").value = result;

	}
</script>
</head>

<body>
	原文：
	<input type="text" id="plaintxt">
	<br /> 密文：
	<input type="text" id="result">
	<button onclick="encrypt();">加密</button>
</body>
</html>
