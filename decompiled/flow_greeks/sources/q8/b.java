package q8;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import q8.d;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f18874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d.a f18875b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18876a;

        static {
            int[] iArr = new int[d.a.values().length];
            f18876a = iArr;
            try {
                iArr[d.a.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18876a[d.a.WARN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18876a[d.a.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18876a[d.a.DEBUG.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public b(d.a aVar, List list) {
        if (list != null) {
            this.f18874a = new HashSet(list);
        } else {
            this.f18874a = null;
        }
        this.f18875b = aVar;
    }

    @Override // q8.d
    public d.a a() {
        return this.f18875b;
    }

    @Override // q8.d
    public void b(d.a aVar, String str, String str2, long j10) {
        if (g(aVar, str)) {
            String strC = c(aVar, str, str2, j10);
            int i10 = a.f18876a[aVar.ordinal()];
            if (i10 == 1) {
                e(str, strC);
                return;
            }
            if (i10 == 2) {
                h(str, strC);
            } else if (i10 == 3) {
                f(str, strC);
            } else {
                if (i10 != 4) {
                    throw new RuntimeException("Should not reach here!");
                }
                d(str, strC);
            }
        }
    }

    public abstract String c(d.a aVar, String str, String str2, long j10);

    public abstract void d(String str, String str2);

    public abstract void e(String str, String str2);

    public abstract void f(String str, String str2);

    public boolean g(d.a aVar, String str) {
        if (aVar.ordinal() >= this.f18875b.ordinal()) {
            return this.f18874a == null || aVar.ordinal() > d.a.DEBUG.ordinal() || this.f18874a.contains(str);
        }
        return false;
    }

    public abstract void h(String str, String str2);
}
