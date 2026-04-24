package J3;

import D3.C0443m;
import K3.AbstractC0612b;
import com.google.protobuf.AbstractC1240i;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class X {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3156a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f3157b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3158c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AbstractC1240i f3159d = AbstractC1240i.f12650b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f3160e = false;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3161a;

        static {
            int[] iArr = new int[C0443m.a.values().length];
            f3161a = iArr;
            try {
                iArr[C0443m.a.ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3161a[C0443m.a.MODIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3161a[C0443m.a.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public void a(G3.k kVar, C0443m.a aVar) {
        this.f3158c = true;
        this.f3157b.put(kVar, aVar);
    }

    public void b() {
        this.f3158c = false;
        this.f3157b.clear();
    }

    public boolean c() {
        return this.f3158c;
    }

    public boolean d() {
        return this.f3160e;
    }

    public boolean e() {
        return this.f3156a != 0;
    }

    public void f() {
        this.f3158c = true;
        this.f3160e = true;
    }

    public void g() {
        this.f3156a++;
    }

    public void h() {
        this.f3156a--;
    }

    public void i(G3.k kVar) {
        this.f3158c = true;
        this.f3157b.remove(kVar);
    }

    public W j() {
        r3.e eVarH = G3.k.h();
        r3.e eVarH2 = G3.k.h();
        r3.e eVarH3 = G3.k.h();
        r3.e eVarC = eVarH;
        r3.e eVarC2 = eVarH2;
        r3.e eVarC3 = eVarH3;
        for (Map.Entry entry : this.f3157b.entrySet()) {
            G3.k kVar = (G3.k) entry.getKey();
            C0443m.a aVar = (C0443m.a) entry.getValue();
            int i7 = a.f3161a[aVar.ordinal()];
            if (i7 == 1) {
                eVarC = eVarC.c(kVar);
            } else if (i7 == 2) {
                eVarC2 = eVarC2.c(kVar);
            } else {
                if (i7 != 3) {
                    throw AbstractC0612b.a("Encountered invalid change type: %s", aVar);
                }
                eVarC3 = eVarC3.c(kVar);
            }
        }
        return new W(this.f3159d, this.f3160e, eVarC, eVarC2, eVarC3);
    }

    public void k(AbstractC1240i abstractC1240i) {
        if (abstractC1240i.isEmpty()) {
            return;
        }
        this.f3158c = true;
        this.f3159d = abstractC1240i;
    }
}
