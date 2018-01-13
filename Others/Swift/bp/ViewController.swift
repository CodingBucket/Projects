
import UIKit

class ViewController: UIViewController {
    
    

 
    override func viewDidLoad(){
        super.viewDidLoad()
        // Do any aditional after loading the view
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that canbe received
    }
    
    override func viewDidAppear(animated: Bool) {
        self.performSegueWithIdentifier("loginView",sender: self);
    }
    

}

