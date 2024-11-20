package net.ivanvega.miapptakephotovideocompose

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class MyReceiverBootCompleted : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        //TODO("MyReceiverBootCompleted.onReceive() is not implemented")
        Log.d("CARGADO", "sE CARGO EL SISTEMA. AQUI SE DEBERAIN REPROGRMAR ALARMAS")
        Log.d("CARGADO",
            "El action del Intent: " + intent.action.toString())
    }
}