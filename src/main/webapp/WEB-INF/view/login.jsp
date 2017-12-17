<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">

<html lang="ja">
	<head>
	<meta http-equiv="Content-Type" Content="text/html;charset=UTF-8">
		<title>ログイン</title>
		<link href="${f:url('/css/login.css')}" rel="stylesheet">
		<script src="JS/jquery-3.1.0.min.js"></script>
		<script src="jquery.cookie.js"></script>
		<script src="bgcolor.js"></script>
	</head>
	<body>
		<div class = "title">
				<h1>チーム出会い系</h1>
				<p>ログイン
				<p>β版
		</div>

		<div class = "form">
			<form action="cgi-bin/formmail.cgi" method="post">
				<table align="center">
				<tr>
					<td>
					ユーザID：
					</td>
					<td>
					<input type="text" name="name" size="10">
					</td>
				</tr>
				<tr>
					<td>
					パスワード：
					</td>
					<td>
					<input type="password" name="pass" maxlength="13" size="10">
					</td>
				</tr>
				<tr>
					<td colspan = "2">
					<input type="submit" value="ログイン">
					<a href="">パスワードを忘れた場合こちら</a>
					</td>
				</tr>
				</table>
			</form>
		</div>
	</body>
</html>