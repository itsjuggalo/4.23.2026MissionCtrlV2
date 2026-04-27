package F3;

import D3.C0443m;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f2024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r3.e f2025c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r3.e f2026d;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2027a;

        static {
            int[] iArr = new int[C0443m.a.values().length];
            f2027a = iArr;
            try {
                iArr[C0443m.a.ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2027a[C0443m.a.REMOVED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public L(int i7, boolean z7, r3.e eVar, r3.e eVar2) {
        this.f2023a = i7;
        this.f2024b = z7;
        this.f2025c = eVar;
        this.f2026d = eVar2;
    }

    public static L a(int i7, D3.z0 z0Var) {
        r3.e eVar = new r3.e(new ArrayList(), G3.k.a());
        r3.e eVar2 = new r3.e(new ArrayList(), G3.k.a());
        for (C0443m c0443m : z0Var.d()) {
            int i8 = a.f2027a[c0443m.c().ordinal()];
            if (i8 == 1) {
                eVar = eVar.c(c0443m.b().getKey());
            } else if (i8 == 2) {
                eVar2 = eVar2.c(c0443m.b().getKey());
            }
        }
        return new L(i7, z0Var.k(), eVar, eVar2);
    }

    public r3.e b() {
        return this.f2025c;
    }

    public r3.e c() {
        return this.f2026d;
    }

    public int d() {
        return this.f2023a;
    }

    public boolean e() {
        return this.f2024b;
    }
}
