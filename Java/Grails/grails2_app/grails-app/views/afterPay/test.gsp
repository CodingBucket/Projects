<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to Grails</title>


		<script src="https://www-sandbox.secure-afterpay.com.au/afterpay.js" async></script>


	</head>
	<body>

	<h3>AfterPay Test</h3>

	<script>
		window.onload = function() {
			AfterPay.init();
			//AfterPay.display({token: "d5f7q6i5odkk2i9rve7lgnkjf8mvurao47uvd1sb5cdpbjnc9tor"});
			AfterPay.redirect({token: "44j2sfnjhev9ltqp6lhu16todfiijg4bap49lshnm1gjg3bsvpnt"});
		};
    </script>

	</body>
</html>
