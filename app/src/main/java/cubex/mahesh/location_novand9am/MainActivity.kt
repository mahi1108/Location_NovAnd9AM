package cubex.mahesh.location_novand9am

import android.content.Context
import android.hardware.Sensor
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var lManager:LocationManager =
                getSystemService(Context.LOCATION_SERVICE) as
                        LocationManager

        lManager.requestLocationUpdates(
                LocationManager.NETWORK_PROVIDER,
                1000.toLong(),1.toFloat(),
                object : LocationListener {
                    override fun onLocationChanged(p0: Location?) {
                        textView.text = p0!!.latitude.toString()
                        textView2.text = p0!!.longitude.toString()
                        lManager.removeUpdates(this)

                     
                    }

                    override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {
                    }

                    override fun onProviderEnabled(p0: String?) {
                    }

                    override fun onProviderDisabled(p0: String?) {
                    }

                })
    }
}
