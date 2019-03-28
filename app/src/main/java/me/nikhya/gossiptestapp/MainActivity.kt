 package me.nikhya.gossiptestapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import me.nikhya.gossip.Gossip
import java.util.*

 class MainActivity : AppCompatActivity() {

     lateinit var gossip: Gossip

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gossip = Gossip(this)

        gossip.setLanguage(Locale("hn"))
        gossip.setSpeed(2.0f)

        gossip.setQueueMode(TextToSpeech.QUEUE_ADD)
        gossip.setQueueMode(TextToSpeech.QUEUE_FLUSH)

        gossip.isPlaying()

        gossip.talkAndOnDone("Something", suspend {
            //do something
        })

        gossip.talk("There she goes",
            onStart = suspend { /*Do some UI change */ },
            onDone = suspend { /*Do some UI change */ },
            onError = suspend { /*Do some UI change */ }
        )

        gossip.talk("SOmething")

    }

}
