package s2;

import android.content.Context;
import android.content.Intent;
import l2.AbstractC2328l;
import l2.AbstractC2331o;
import l2.C2329m;
import t2.C2742i;
import t2.t;
import t2.w;

/* JADX INFO: renamed from: s2.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2698m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C2742i f23078c = new C2742i("ReviewService");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t f23079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f23080b;

    /* JADX WARN: Type inference failed for: r7v0, types: [s2.i] */
    public C2698m(Context context) {
        this.f23080b = context.getPackageName();
        if (w.a(context)) {
            this.f23079a = new t(context, f23078c, "com.google.android.finsky.inappreviewservice.InAppReviewService", new Intent("com.google.android.finsky.BIND_IN_APP_REVIEW_SERVICE").setPackage("com.android.vending"), new Object() { // from class: s2.i
            }, null);
        }
    }

    public final AbstractC2328l a() {
        String str = this.f23080b;
        C2742i c2742i = f23078c;
        c2742i.c("requestInAppReview (%s)", str);
        if (this.f23079a == null) {
            c2742i.a("Play Store app is either not installed or not the official version", new Object[0]);
            return AbstractC2331o.d(new C2686a(-1));
        }
        C2329m c2329m = new C2329m();
        this.f23079a.s(new C2695j(this, c2329m, c2329m), c2329m);
        return c2329m.a();
    }
}
