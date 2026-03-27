package io.flutter.plugins.firebase.messaging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.util.Log;
import com.google.firebase.messaging.d;
import h5.AbstractC1724a;
import h5.C1716B;
import h5.y;
import h5.z;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class FlutterFirebaseMessagingReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HashMap f16823a = new HashMap();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Log.d("FLTFireMsgReceiver", "broadcast received for message");
        if (AbstractC1724a.a() == null) {
            AbstractC1724a.b(context.getApplicationContext() != null ? context.getApplicationContext() : context);
        }
        if (intent.getExtras() == null) {
            Log.d("FLTFireMsgReceiver", "broadcast received but intent contained no extras to process RemoteMessage. Operation cancelled.");
            return;
        }
        d dVar = new d(intent.getExtras());
        if (dVar.G() != null) {
            f16823a.put(dVar.D(), dVar);
            y.b().i(dVar);
        }
        if (z.d(context)) {
            C1716B.o().p(dVar);
            return;
        }
        Intent intent2 = new Intent(context, (Class<?>) FlutterFirebaseMessagingBackgroundService.class);
        Parcel parcelObtain = Parcel.obtain();
        dVar.writeToParcel(parcelObtain, 0);
        intent2.putExtra("notification", parcelObtain.marshall());
        FlutterFirebaseMessagingBackgroundService.k(context, intent2, dVar.H() == 1);
    }
}
