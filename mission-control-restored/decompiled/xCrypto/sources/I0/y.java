package I0;

import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class y {

    public interface a {
        void onSuccess(int i4);
    }

    public static boolean e(Context context) {
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "location_mode") != 0;
        } catch (Settings.SettingNotFoundException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public void a(int i4, Context context, a aVar, b bVar) {
        if (context == null) {
            Log.d("permissions_handler", "Context cannot be null.");
            bVar.a("PermissionHandler.ServiceManager", "Android context cannot be null.");
            return;
        }
        if (i4 == 3 || i4 == 4 || i4 == 5) {
            aVar.onSuccess(d(context) ? 1 : 0);
            return;
        }
        if (i4 == 21) {
            aVar.onSuccess(c(context) ? 1 : 0);
            return;
        }
        if (i4 != 8) {
            if (i4 == 16) {
                aVar.onSuccess(1);
                return;
            } else {
                aVar.onSuccess(2);
                return;
            }
        }
        PackageManager packageManager = context.getPackageManager();
        if (!packageManager.hasSystemFeature("android.hardware.telephony")) {
            aVar.onSuccess(2);
            return;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null || telephonyManager.getPhoneType() == 0) {
            aVar.onSuccess(2);
            return;
        }
        if (b(packageManager).isEmpty()) {
            aVar.onSuccess(2);
        } else if (telephonyManager.getSimState() != 5) {
            aVar.onSuccess(0);
        } else {
            aVar.onSuccess(1);
        }
    }

    public final List b(PackageManager packageManager) {
        Intent intent = new Intent("android.intent.action.CALL");
        intent.setData(Uri.parse("tel:123123"));
        return Build.VERSION.SDK_INT >= 33 ? packageManager.queryIntentActivities(intent, PackageManager.ResolveInfoFlags.of(0L)) : packageManager.queryIntentActivities(intent, 0);
    }

    public final boolean c(Context context) {
        return ((BluetoothManager) context.getSystemService("bluetooth")).getAdapter().isEnabled();
    }

    public final boolean d(Context context) {
        if (Build.VERSION.SDK_INT < 28) {
            return e(context);
        }
        LocationManager locationManager = (LocationManager) context.getSystemService(LocationManager.class);
        if (locationManager == null) {
            return false;
        }
        return locationManager.isLocationEnabled();
    }
}
