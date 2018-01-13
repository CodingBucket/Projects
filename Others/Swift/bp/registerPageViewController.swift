

import UIKit



class RegisterPageViewController: UIViewController {
    
    
    
    
    @IBOutlet weak var userEmail: UITextField!
    
    @IBOutlet weak var userPassword: UITextField!
    
    override func viewDidLoad() {
        
        super.viewDidLoad()
        
        // Do any additional setup after loading the view.
        
    }
    
    
    
    override func didReceiveMemoryWarning() {
        
        super.didReceiveMemoryWarning()
        
        // Dispose of any resources that can be recreated.
        
    }
    
    
    
    @IBAction func signUp(sender: AnyObject) {
        
        let userEmailField = userEmail.text;
        let userPasswordField = userPassword.text;
        
        //check for empty fields
        if(userEmailField!.isEmpty){
            displayMyAlertMessage("All fields are required");
            return;
        }
        
        
        if(userPasswordField!.isEmpty){
            displayMyAlertMessage("All fields are required");
        }
        
        
        // prepare json data
        //let mapDict = [ "1":"First", "2":"Second"]
        //let json = [ "title":"ABC" , "dict": mapDict ]
        //let jsonData = NSJSONSerialization.dataWithJSONObject(json, options: .PrettyPrinted, error: nil)
        
        // prepare data to post
        //let postString = "email=\(userEmailField)&password=\(userPasswordField)";
        
        let postString = "email=hasan&password=123456";
        let jsonData = postString.dataUsingEncoding(NSUTF8StringEncoding);
        
        print("I am here")

        
        // create post request
        let url = NSURL(string: "http://ringcreations.webtogo.info/api_login")!
        let request = NSMutableURLRequest(URL: url)
        request.HTTPMethod = "POST"
        
        // insert json data to the request
        request.HTTPBody = jsonData
        
        
        let task = NSURLSession.sharedSession().dataTaskWithRequest(request){ data,response,error in
            if error != nil{
                print(error!.localizedDescription)
                return
            }
            
            do {
                if let jsonResult = try NSJSONSerialization.JSONObjectWithData(data!, options: []) as? NSDictionary {
                    print(jsonResult)
                }
            } catch let error as NSError {
                print(error.localizedDescription)
            }
            
        }
        
        task.resume()
    
        
    }
    
    
    func displayMyAlertMessage(userMessage:String){
        
        let myAlert = UIAlertController(title:"Alert", message:
            userMessage, preferredStyle:
            UIAlertControllerStyle.Alert);
        
        let okAction = UIAlertAction(title:"OK", style:
            UIAlertActionStyle.Default, handler:nil);
        
        myAlert.addAction(okAction);
        
        self.presentViewController(myAlert, animated:true,completion:nil);

        
    }

}


