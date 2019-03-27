 package me.nikhya.gossiptestapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import me.nikhya.gossip.Gossip

 class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gossip = Gossip(this)

        gossip.talk("SOmething")

    }
}
