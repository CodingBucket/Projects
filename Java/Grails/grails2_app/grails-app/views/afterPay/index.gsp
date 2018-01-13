<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to Grails</title>


		<script src="https://www-sandbox.secure-afterpay.com.au/afterpay.js" async></script>


	</head>
	<body>

	<h3>${token}</h3>

	<script>
		window.onload = function() {
			AfterPay.init();
			AfterPay.display({token: "${token}"});
		};
    </script>

	</body>
</html>
