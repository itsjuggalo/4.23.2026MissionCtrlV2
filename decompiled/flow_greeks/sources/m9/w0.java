package m9;

import g9.m;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16305a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f16306b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f16307c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.google.protobuf.i f16308d = com.google.protobuf.i.f6998b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f16309e = false;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16310a;

        static {
            int[] iArr = new int[m.a.values().length];
            f16310a = iArr;
            try {
                iArr[m.a.ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16310a[m.a.MODIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16310a[m.a.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public void a(j9.k kVar, m.a aVar) {
        this.f16307c = true;
        this.f16306b.put(kVar, aVar);
    }

    public void b() {
        this.f16307c = false;
        this.f16306b.clear();
    }

    public boolean c() {
        return this.f16307c;
    }

    public boolean d() {
        return this.f16309e;
    }

    public boolean e() {
        return this.f16305a != 0;
    }

    public void f() {
        this.f16307c = true;
        this.f16309e = true;
    }

    public void g() {
        this.f16305a++;
    }

    public void h() {
        this.f16305a--;
    }

    public void i(j9.k kVar) {
        this.f16307c = true;
        this.f16306b.remove(kVar);
    }

    public v0 j() {
        g8.e eVarH = j9.k.h();
        g8.e eVarH2 = j9.k.h();
        g8.e eVarH3 = j9.k.h();
        g8.e eVarE = eVarH;
        g8.e eVarE2 = eVarH2;
        g8.e eVarE3 = eVarH3;
        for (Map.Entry entry : this.f16306b.entrySet()) {
            j9.k kVar = (j9.k) entry.getKey();
            m.a aVar = (m.a) entry.getValue();
            int i10 = a.f16310a[aVar.ordinal()];
            if (i10 == 1) {
                eVarE = eVarE.e(kVar);
            } else if (i10 == 2) {
                eVarE2 = eVarE2.e(kVar);
            } else {
                if (i10 != 3) {
                    throw n9.b.a("Encountered invalid change type: %s", aVar);
                }
                eVarE3 = eVarE3.e(kVar);
            }
        }
        return new v0(this.f16308d, this.f16309e, eVarE, eVarE2, eVarE3);
    }

    public void k(com.google.protobuf.i iVar) {
        if (iVar.isEmpty()) {
            return;
        }
        this.f16307c = true;
        this.f16308d = iVar;
    }
}
