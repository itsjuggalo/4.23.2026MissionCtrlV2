package androidx.core.app;

import E0.a;
import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;

/* JADX INFO: loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f11078a = (IconCompat) aVar.v(remoteActionCompat.f11078a, 1);
        remoteActionCompat.f11079b = aVar.l(remoteActionCompat.f11079b, 2);
        remoteActionCompat.f11080c = aVar.l(remoteActionCompat.f11080c, 3);
        remoteActionCompat.f11081d = (PendingIntent) aVar.r(remoteActionCompat.f11081d, 4);
        remoteActionCompat.f11082e = aVar.h(remoteActionCompat.f11082e, 5);
        remoteActionCompat.f11083f = aVar.h(remoteActionCompat.f11083f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, a aVar) {
        aVar.x(false, false);
        aVar.M(remoteActionCompat.f11078a, 1);
        aVar.D(remoteActionCompat.f11079b, 2);
        aVar.D(remoteActionCompat.f11080c, 3);
        aVar.H(remoteActionCompat.f11081d, 4);
        aVar.z(remoteActionCompat.f11082e, 5);
        aVar.z(remoteActionCompat.f11083f, 6);
    }
}
