package t;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import x.AbstractC1394b;

/* JADX INFO: renamed from: t.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1100m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f9821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IconCompat f9822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d0[] f9823c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f9824d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f9825f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f9826g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f9827h;
    public final CharSequence i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PendingIntent f9828j;

    public C1100m(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, d0[] d0VarArr, d0[] d0VarArr2, boolean z6, int i, boolean z7, boolean z8) {
        this.e = true;
        this.f9822b = iconCompat;
        if (iconCompat != null) {
            int i6 = iconCompat.f4427a;
            if ((i6 == -1 ? AbstractC1394b.c(iconCompat.f4428b) : i6) == 2) {
                this.f9827h = iconCompat.f();
            }
        }
        this.i = C1105s.b(charSequence);
        this.f9828j = pendingIntent;
        this.f9821a = bundle == null ? new Bundle() : bundle;
        this.f9823c = d0VarArr;
        this.f9824d = z6;
        this.f9825f = i;
        this.e = z7;
        this.f9826g = z8;
    }

    public final IconCompat a() {
        int i;
        if (this.f9822b == null && (i = this.f9827h) != 0) {
            this.f9822b = IconCompat.e(null, "", i);
        }
        return this.f9822b;
    }
}
