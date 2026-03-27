package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import t0.AbstractC1782a;

/* JADX INFO: loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(AbstractC1782a abstractC1782a) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f6845a = (IconCompat) abstractC1782a.v(remoteActionCompat.f6845a, 1);
        remoteActionCompat.f6846b = abstractC1782a.l(remoteActionCompat.f6846b, 2);
        remoteActionCompat.f6847c = abstractC1782a.l(remoteActionCompat.f6847c, 3);
        remoteActionCompat.f6848d = (PendingIntent) abstractC1782a.r(remoteActionCompat.f6848d, 4);
        remoteActionCompat.f6849e = abstractC1782a.h(remoteActionCompat.f6849e, 5);
        remoteActionCompat.f6850f = abstractC1782a.h(remoteActionCompat.f6850f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, AbstractC1782a abstractC1782a) {
        abstractC1782a.x(false, false);
        abstractC1782a.M(remoteActionCompat.f6845a, 1);
        abstractC1782a.D(remoteActionCompat.f6846b, 2);
        abstractC1782a.D(remoteActionCompat.f6847c, 3);
        abstractC1782a.H(remoteActionCompat.f6848d, 4);
        abstractC1782a.z(remoteActionCompat.f6849e, 5);
        abstractC1782a.z(remoteActionCompat.f6850f, 6);
    }
}
