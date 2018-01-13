

import UIKit
import AVFoundation

class PlaySoundViewController: UIViewController {
    
    var player: AVAudioPlayer?

    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
       
        
        let url = NSBundle.mainBundle().URLForResource("1", withExtension: "mp3")!
        do {
            player = try AVAudioPlayer(contentsOfURL: url)
            
        } catch let error as NSError {
            print(error.description)
        }
        
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    

    @IBAction func audioPlay(sender: AnyObject) {
        
        // Play audio
        guard let player = player else { return }
        player.stop()
        player.enableRate = false
        player.currentTime = 0.0
        player.prepareToPlay()
        player.play()
        
    }
    @IBAction func playFastAudio(sender: AnyObject) {
        
        // Play fast audio
        guard let player = player else { return }
        player.stop()
        player.enableRate = true
        player.rate = 2                // Playback speed
        player.currentTime = 0.0
        player.prepareToPlay()
        player.play()
        
    }
    
    
    @IBAction func playSlowAudio(sender: AnyObject) {
        
        // Play audio sloowly here....
        guard let player = player else { return }
        player.stop()
        player.enableRate = true
        player.rate = 0.4
        player.currentTime = 0.0
        player.prepareToPlay()
        player.play()
        
        
    }
   

    @IBAction func stopAudio(sender: AnyObject) {
        
        // Stop audio
        guard let player = player else { return }
        player.stop()
    
        
    }
    
    
    
}
