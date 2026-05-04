package i9;

import g9.m;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f12069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g8.e f12070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g8.e f12071d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12072a;

        static {
            int[] iArr = new int[m.a.values().length];
            f12072a = iArr;
            try {
                iArr[m.a.ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12072a[m.a.REMOVED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public l0(int i10, boolean z10, g8.e eVar, g8.e eVar2) {
        this.f12068a = i10;
        this.f12069b = z10;
        this.f12070c = eVar;
        this.f12071d = eVar2;
    }

    public static l0 a(int i10, g9.y1 y1Var) {
        g8.e eVar = new g8.e(new ArrayList(), j9.k.a());
        g8.e eVar2 = new g8.e(new ArrayList(), j9.k.a());
        for (g9.m mVar : y1Var.d()) {
            int i11 = a.f12072a[mVar.c().ordinal()];
            if (i11 == 1) {
                eVar = eVar.e(mVar.b().getKey());
            } else if (i11 == 2) {
                eVar2 = eVar2.e(mVar.b().getKey());
            }
        }
        return new l0(i10, y1Var.k(), eVar, eVar2);
    }

    public g8.e b() {
        return this.f12070c;
    }

    public g8.e c() {
        return this.f12071d;
    }

    public int d() {
        return this.f12068a;
    }

    public boolean e() {
        return this.f12069b;
    }
}
