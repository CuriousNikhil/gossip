
Gossip
======
**Gossip** is Android TextToSpeech Helper. This is easiest way to use TextToSpeech on android where you can handle all events of TextToSpeech on UI.

## Installation
Add the following line in your app level `build.gradle` file and you can gossip.

    implementation 'me.nikhilchaudhari.gossip:1.0.0'

## Usage
1. Initialise the `Gossip` as

        class MainActivity : AppCompatActivity() {
            lateinit var gossip: Gossip

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)
                gossip = Gossip(this)
            }
        }

2. Basic gossiping

       gossip.talk("She is beautiful")

The above code will initialise and start a `TextToSpeech` of Android and will speak the string passed.

3. Perform UI operations on `TextToSpeech` speak events
There are three methods, you can use three to handle `onStart` `onDone` & `onError` states of `TextToSpeech`

    - **talkAndOnStart**

          gossip.talkAndOnStart("She should change her dressing", suspend {
                // Any UI/ MainThread changes
                girl_image_view.setBackgroundResource = R.drawable.red_dress
            })
        The suspend lambda will be invoked at the time when TextToSpeech will start the talking of passed string.

    - **talkAndOnDone**

          gossip.talkAndOnDone("She should put a lipstik as final touch", suspend {
                // Any UI/ MainThread changes
                girl_image_view.setBackgroundResource = R.drawable.lipstik
            })
        The suspend lambda will be invoked at the time when TextToSpeech will end the talking of passed string.

    - **talkAndOnError**

          gossip.talkAndOnStart("She messed up her makeup", suspend {
               // Any UI/ MainThread changes
                girl_image_view.setBackgroundResource = R.drawable.messed_up_girl
            })
        The suspend lambda will be invoked at the time when there is an error in speaking the given string.

    If you want to define all three events at once, you can use the following method

         gossip.talk("There she goes",
            onStart = suspend { /*Do some UI change */ },
            onDone = suspend { /*Do some UI change */ },
            onError = suspend { /*Do some UI change */ }
         )

3. Stop Gossiping
Stop the TTS with `stop()` method

        gossip.stop()

4. Take care of all AfterParty mess
Stop the TTS engine to avoid memory leaks.

        override fun onDestroy() {
            super.onDestroy()
            gossip.shutdown()
        }


