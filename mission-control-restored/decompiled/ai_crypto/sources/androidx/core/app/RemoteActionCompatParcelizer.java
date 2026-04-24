package androidx.core.app;

import K0.a;
import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;

/* JADX INFO: loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f7253a = (IconCompat) aVar.v(remoteActionCompat.f7253a, 1);
        remoteActionCompat.f7254b = aVar.l(remoteActionCompat.f7254b, 2);
        remoteActionCompat.f7255c = aVar.l(remoteActionCompat.f7255c, 3);
        remoteActionCompat.f7256d = (PendingIntent) aVar.r(remoteActionCompat.f7256d, 4);
        remoteActionCompat.f7257e = aVar.h(remoteActionCompat.f7257e, 5);
        remoteActionCompat.f7258f = aVar.h(remoteActionCompat.f7258f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, a aVar) {
        aVar.x(false, false);
        aVar.M(remoteActionCompat.f7253a, 1);
        aVar.D(remoteActionCompat.f7254b, 2);
        aVar.D(remoteActionCompat.f7255c, 3);
        aVar.H(remoteActionCompat.f7256d, 4);
        aVar.z(remoteActionCompat.f7257e, 5);
        aVar.z(remoteActionCompat.f7258f, 6);
    }
}
