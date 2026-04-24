package S1;

import com.google.android.gms.common.api.Status;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import l2.C2329m;

/* JADX INFO: renamed from: S1.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0884p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f7435a = Collections.synchronizedMap(new WeakHashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f7436b = Collections.synchronizedMap(new WeakHashMap());

    public final void b(C2329m c2329m, boolean z7) {
        this.f7436b.put(c2329m, Boolean.valueOf(z7));
        c2329m.a().c(new C0883o(this, c2329m));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(int r4, java.lang.String r5) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "The connection to Google Play services was lost"
            r0.<init>(r1)
            r1 = 1
            if (r4 != r1) goto L10
            java.lang.String r4 = " due to service disconnection."
        Lc:
            r0.append(r4)
            goto L16
        L10:
            r2 = 3
            if (r4 != r2) goto L16
            java.lang.String r4 = " due to dead object exception."
            goto Lc
        L16:
            if (r5 == 0) goto L20
            java.lang.String r4 = " Last reason for disconnect: "
            r0.append(r4)
            r0.append(r5)
        L20:
            java.lang.String r4 = r0.toString()
            com.google.android.gms.common.api.Status r5 = new com.google.android.gms.common.api.Status
            r0 = 20
            r5.<init>(r0, r4)
            r3.f(r1, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: S1.C0884p.c(int, java.lang.String):void");
    }

    public final void d() {
        f(false, C0873e.f7405p);
    }

    public final boolean e() {
        return (this.f7435a.isEmpty() && this.f7436b.isEmpty()) ? false : true;
    }

    public final void f(boolean z7, Status status) {
        HashMap map;
        HashMap map2;
        synchronized (this.f7435a) {
            map = new HashMap(this.f7435a);
        }
        synchronized (this.f7436b) {
            map2 = new HashMap(this.f7436b);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (z7 || ((Boolean) entry.getValue()).booleanValue()) {
                android.support.v4.media.session.b.a(entry.getKey());
                throw null;
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (z7 || ((Boolean) entry2.getValue()).booleanValue()) {
                ((C2329m) entry2.getKey()).d(new R1.b(status));
            }
        }
    }
}
