package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import p2.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f1558a = (IconCompat) aVar.v(remoteActionCompat.f1558a, 1);
        remoteActionCompat.f1559b = aVar.l(remoteActionCompat.f1559b, 2);
        remoteActionCompat.f1560c = aVar.l(remoteActionCompat.f1560c, 3);
        remoteActionCompat.f1561d = (PendingIntent) aVar.r(remoteActionCompat.f1561d, 4);
        remoteActionCompat.f1562e = aVar.h(remoteActionCompat.f1562e, 5);
        remoteActionCompat.f1563f = aVar.h(remoteActionCompat.f1563f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, a aVar) {
        aVar.x(false, false);
        aVar.M(remoteActionCompat.f1558a, 1);
        aVar.D(remoteActionCompat.f1559b, 2);
        aVar.D(remoteActionCompat.f1560c, 3);
        aVar.H(remoteActionCompat.f1561d, 4);
        aVar.z(remoteActionCompat.f1562e, 5);
        aVar.z(remoteActionCompat.f1563f, 6);
    }
}
