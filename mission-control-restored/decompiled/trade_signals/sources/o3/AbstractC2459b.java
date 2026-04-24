package o3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import o3.InterfaceC2461d;

/* JADX INFO: renamed from: o3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2459b implements InterfaceC2461d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f21927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2461d.a f21928b;

    /* JADX INFO: renamed from: o3.b$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21929a;

        static {
            int[] iArr = new int[InterfaceC2461d.a.values().length];
            f21929a = iArr;
            try {
                iArr[InterfaceC2461d.a.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21929a[InterfaceC2461d.a.WARN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f21929a[InterfaceC2461d.a.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f21929a[InterfaceC2461d.a.DEBUG.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public AbstractC2459b(InterfaceC2461d.a aVar, List list) {
        if (list != null) {
            this.f21927a = new HashSet(list);
        } else {
            this.f21927a = null;
        }
        this.f21928b = aVar;
    }

    @Override // o3.InterfaceC2461d
    public InterfaceC2461d.a a() {
        return this.f21928b;
    }

    @Override // o3.InterfaceC2461d
    public void b(InterfaceC2461d.a aVar, String str, String str2, long j8) {
        if (g(aVar, str)) {
            String strC = c(aVar, str, str2, j8);
            int i8 = a.f21929a[aVar.ordinal()];
            if (i8 == 1) {
                e(str, strC);
                return;
            }
            if (i8 == 2) {
                h(str, strC);
            } else if (i8 == 3) {
                f(str, strC);
            } else {
                if (i8 != 4) {
                    throw new RuntimeException("Should not reach here!");
                }
                d(str, strC);
            }
        }
    }

    public abstract String c(InterfaceC2461d.a aVar, String str, String str2, long j8);

    public abstract void d(String str, String str2);

    public abstract void e(String str, String str2);

    public abstract void f(String str, String str2);

    public boolean g(InterfaceC2461d.a aVar, String str) {
        return aVar.ordinal() >= this.f21928b.ordinal() && (this.f21927a == null || aVar.ordinal() > InterfaceC2461d.a.DEBUG.ordinal() || this.f21927a.contains(str));
    }

    public abstract void h(String str, String str2);
}
