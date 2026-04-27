package S1;

import android.util.Log;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.revenuecat.purchases.common.Constants;
import java.util.Objects;

/* JADX INFO: renamed from: S1.z2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0728z2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f5076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f5078d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f5079e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ C2 f5080f;

    public RunnableC0728z2(C2 c22, int i4, String str, Object obj, Object obj2, Object obj3) {
        this.f5075a = i4;
        this.f5076b = str;
        this.f5077c = obj;
        this.f5078d = obj2;
        this.f5079e = obj3;
        Objects.requireNonNull(c22);
        this.f5080f = c22;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2 c22 = this.f5080f;
        Q2 q2X = c22.f4245a.x();
        if (!q2X.k()) {
            Log.println(6, c22.z(), "Persisted config not initialized. Not logging error/warn");
            return;
        }
        if (c22.D() == 0) {
            C0658q3 c0658q3 = c22.f4245a;
            if (c0658q3.w().B()) {
                c0658q3.c();
                c22.E('C');
            } else {
                c0658q3.c();
                c22.E('c');
            }
        }
        if (c22.F() < 0) {
            c22.f4245a.w().A();
            c22.G(130000L);
        }
        int i4 = this.f5075a;
        char cD = c22.D();
        long jF = c22.F();
        String str = this.f5076b;
        Object obj = this.f5077c;
        Object obj2 = this.f5078d;
        Object obj3 = this.f5079e;
        char cCharAt = "01VDIWEA?".charAt(i4);
        String strA = C2.A(true, str, obj, obj2, obj3);
        int length = String.valueOf(cCharAt).length();
        StringBuilder sb = new StringBuilder(length + 1 + String.valueOf(cD).length() + String.valueOf(jF).length() + 1 + strA.length());
        sb.append("2");
        sb.append(cCharAt);
        sb.append(cD);
        sb.append(jF);
        sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        sb.append(strA);
        String string = sb.toString();
        if (string.length() > 1024) {
            string = str.substring(0, UserMetadata.MAX_ATTRIBUTE_SIZE);
        }
        O2 o22 = q2X.f4183e;
        if (o22 != null) {
            o22.a(string, 1L);
        }
    }
}
