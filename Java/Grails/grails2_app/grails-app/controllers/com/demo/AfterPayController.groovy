package com.demo

import grails.converters.JSON

class AfterPayController {

    def test() {

    }

    def confirm() {
        retrun 'confirm';
    }

    def cancel() {
        return 'cancel';
    }


    def index(){

        String request = "https://api-sandbox.secure-afterpay.com.au/v1/orders";

        def data = [:];
        data.totalAmount = [
                amount: "10.00",
                currency: "AUD"
        ]
        data.consumer = [
                phoneNumber: "123456",
                givenNames: "Hasan",
                surname: "Khan",
                email: "hasan.khan.uap@gmail.com"
        ]
        data.merchant = [
                redirectConfirmUrl: "https://www.merchant.com/confirm",
                redirectCancelUrl: "https://www.merchant.com/cancel"
        ]

        def postData = data as JSON

        URL obj = new URL(request);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // Add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", "Basic MzI5NzY6YWFmYTMxZDViYzA5MmYxM2JiOWUyYTcxMTkxMmUzYzNkMzg3YjQzYjNmNTY1NWYxNWRhNmRhNGU0ZWU2MjlkNTYxMDExMGEyYjkzOGMwNTY0MDBlOTQyZWEyZjBmYjE1ZTU1ZDg1OTU0YTFmMjMxZTlhOTVlNTM0MmZjYjI2NTU=");

        // String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
        String urlParameters = postData.toString();

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + request);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader input = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = input.readLine()) != null) {
            response.append(inputLine);
        }
        input.close();
        System.out.println("Response : " + response);
        //render response;

        def tweetJson = JSON.parse(response.toString());
        System.out.println("tweetJson : " + tweetJson);
        System.out.println("token : " + tweetJson['token']);

        //render tweetJson['token']
        def token = tweetJson['token']
        [token:token]


    }

    def getOrder() {

        String request = "https://api-sandbox.secure-afterpay.com.au/v1/orders";

        def data = [:];
        data.totalAmount = [
                amount: "10.00",
                currency: "AUD"
        ]
        data.consumer = [
                offset: "0422042042",
                givenNames: "Joe",
                surname: "Consumer",
                email: "test@afterpay.com.au"
        ]
        data.merchant = [
                redirectConfirmUrl: "https://www.merchant.com/confirm",
                redirectCancelUrl: "https://www.merchant.com/cancel"
        ]

        def postData = data as JSON

        URL obj = new URL(request);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // Add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", "Basic MzI5NzY6YWFmYTMxZDViYzA5MmYxM2JiOWUyYTcxMTkxMmUzYzNkMzg3YjQzYjNmNTY1NWYxNWRhNmRhNGU0ZWU2MjlkNTYxMDExMGEyYjkzOGMwNTY0MDBlOTQyZWEyZjBmYjE1ZTU1ZDg1OTU0YTFmMjMxZTlhOTVlNTM0MmZjYjI2NTU=");

        // String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
        String urlParameters = postData.toString();

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + request);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader input = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = input.readLine()) != null) {
            response.append(inputLine);
        }
        input.close();

        render response;


    }

    def getConfiguration() {
        String request = "https://api-sandbox.secure-afterpay.com.au/v1/configuration";
        URL url = new URL( request );
        HttpURLConnection conn= (HttpURLConnection) url.openConnection();
        conn.setDoOutput( true );
        conn.setInstanceFollowRedirects( false );
        conn.setRequestMethod( "GET" );
        conn.setRequestProperty( "Authorization", "Basic MzI5NzY6YWFmYTMxZDViYzA5MmYxM2JiOWUyYTcxMTkxMmUzYzNkMzg3YjQzYjNmNTY1NWYxNWRhNmRhNGU0ZWU2MjlkNTYxMDExMGEyYjkzOGMwNTY0MDBlOTQyZWEyZjBmYjE1ZTU1ZDg1OTU0YTFmMjMxZTlhOTVlNTM0MmZjYjI2NTU=");
        conn.setUseCaches( false );
        StringBuffer answer = new StringBuffer();
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            answer.append(line);
        }
        reader.close();
        answer.toString();
    }
}
