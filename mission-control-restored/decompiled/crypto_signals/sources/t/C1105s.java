package t;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import com.cryptosignals.ap.android.R;
import java.util.ArrayList;

/* JADX INFO: renamed from: t.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1105s {

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public String f9834B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public String f9835C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public long f9836D;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public final boolean f9838F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public final Notification f9839G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public boolean f9840H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public final ArrayList f9841I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9842a;
    public CharSequence e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CharSequence f9846f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PendingIntent f9847g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PendingIntent f9848h;
    public IconCompat i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f9849j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f9850k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f9852m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public AbstractC1085G f9853n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CharSequence f9854o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f9855p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f9856q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f9857r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f9858s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f9859t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f9861v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f9862w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f9863x;
    public Bundle y;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f9843b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f9844c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f9845d = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f9851l = true;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f9860u = false;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f9864z = 0;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public int f9833A = 0;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public int f9837E = 0;

    public C1105s(Context context, String str) {
        Notification notification = new Notification();
        this.f9839G = notification;
        this.f9842a = context;
        this.f9834B = str;
        notification.when = System.currentTimeMillis();
        notification.audioStreamType = -1;
        this.f9850k = 0;
        this.f9841I = new ArrayList();
        this.f9838F = true;
    }

    public static CharSequence b(CharSequence charSequence) {
        return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
    }

    public final Notification a() {
        Notification notificationBuild;
        Bundle bundle;
        com.google.firebase.storage.z zVar = new com.google.firebase.storage.z(this);
        C1105s c1105s = (C1105s) zVar.e;
        AbstractC1085G abstractC1085G = c1105s.f9853n;
        if (abstractC1085G != null) {
            abstractC1085G.b(zVar);
        }
        int i = Build.VERSION.SDK_INT;
        Notification.Builder builder = (Notification.Builder) zVar.f5631d;
        if (i >= 26) {
            notificationBuild = builder.build();
        } else {
            Notification notificationBuild2 = builder.build();
            int i6 = zVar.f5629b;
            if (i6 != 0) {
                if (AbstractC1086H.f(notificationBuild2) != null && (notificationBuild2.flags & 512) != 0 && i6 == 2) {
                    notificationBuild2.sound = null;
                    notificationBuild2.vibrate = null;
                    notificationBuild2.defaults &= -4;
                }
                if (AbstractC1086H.f(notificationBuild2) != null && (notificationBuild2.flags & 512) == 0 && i6 == 1) {
                    notificationBuild2.sound = null;
                    notificationBuild2.vibrate = null;
                    notificationBuild2.defaults &= -4;
                }
            }
            notificationBuild = notificationBuild2;
        }
        if (abstractC1085G != null) {
            c1105s.f9853n.getClass();
        }
        if (abstractC1085G != null && (bundle = notificationBuild.extras) != null) {
            abstractC1085G.a(bundle);
        }
        return notificationBuild;
    }

    public final void c(int i, boolean z6) {
        Notification notification = this.f9839G;
        if (z6) {
            notification.flags = i | notification.flags;
        } else {
            notification.flags = (~i) & notification.flags;
        }
    }

    public final void d(Bitmap bitmap) {
        IconCompat iconCompatD;
        if (bitmap == null) {
            iconCompatD = null;
        } else {
            if (Build.VERSION.SDK_INT < 27) {
                Resources resources = this.f9842a.getResources();
                int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_width);
                int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_height);
                if (bitmap.getWidth() > dimensionPixelSize || bitmap.getHeight() > dimensionPixelSize2) {
                    double dMin = Math.min(((double) dimensionPixelSize) / ((double) Math.max(1, bitmap.getWidth())), ((double) dimensionPixelSize2) / ((double) Math.max(1, bitmap.getHeight())));
                    bitmap = Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * dMin), (int) Math.ceil(((double) bitmap.getHeight()) * dMin), true);
                }
            }
            iconCompatD = IconCompat.d(bitmap);
        }
        this.i = iconCompatD;
    }

    public final void e(Uri uri) {
        Notification notification = this.f9839G;
        notification.sound = uri;
        notification.audioStreamType = -1;
        notification.audioAttributes = r.a(r.e(r.c(r.b(), 4), 5));
    }

    public final void f(AbstractC1085G abstractC1085G) {
        if (this.f9853n != abstractC1085G) {
            this.f9853n = abstractC1085G;
            if (abstractC1085G == null || abstractC1085G.f9777a == this) {
                return;
            }
            abstractC1085G.f9777a = this;
            f(abstractC1085G);
        }
    }
}
