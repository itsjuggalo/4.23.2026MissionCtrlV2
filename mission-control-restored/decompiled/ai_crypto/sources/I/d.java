package I;

import H.d;
import H.f;
import N.g;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import u.C2740e;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f2682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C2740e f2683b;

    public static class a extends g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public f.e f2684a;

        public a(f.e eVar) {
            this.f2684a = eVar;
        }

        @Override // N.g.c
        public void a(int i7) {
            f.e eVar = this.f2684a;
            if (eVar != null) {
                eVar.f(i7);
            }
        }

        @Override // N.g.c
        public void b(Typeface typeface) {
            f.e eVar = this.f2684a;
            if (eVar != null) {
                eVar.g(typeface);
            }
        }
    }

    static {
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 29) {
            f2682a = new i();
        } else if (i7 >= 28) {
            f2682a = new h();
        } else if (i7 >= 26) {
            f2682a = new g();
        } else if (f.j()) {
            f2682a = new f();
        } else {
            f2682a = new e();
        }
        f2683b = new C2740e(16);
    }

    public static Typeface a(Context context, Typeface typeface, int i7) {
        if (context != null) {
            return Typeface.create(typeface, i7);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface b(Context context, CancellationSignal cancellationSignal, g.b[] bVarArr, int i7) {
        return f2682a.b(context, cancellationSignal, bVarArr, i7);
    }

    public static Typeface c(Context context, d.b bVar, Resources resources, int i7, String str, int i8, int i9, f.e eVar, Handler handler, boolean z7) {
        Typeface typefaceA;
        if (bVar instanceof d.e) {
            d.e eVar2 = (d.e) bVar;
            Typeface typefaceG = g(eVar2.c());
            if (typefaceG != null) {
                if (eVar != null) {
                    eVar.d(typefaceG, handler);
                }
                return typefaceG;
            }
            typefaceA = N.g.c(context, eVar2.b(), i9, !z7 ? eVar != null : eVar2.a() != 0, z7 ? eVar2.d() : -1, f.e.e(handler), new a(eVar));
        } else {
            typefaceA = f2682a.a(context, (d.c) bVar, resources, i9);
            if (eVar != null) {
                if (typefaceA != null) {
                    eVar.d(typefaceA, handler);
                } else {
                    eVar.c(-3, handler);
                }
            }
        }
        if (typefaceA != null) {
            f2683b.put(e(resources, i7, str, i8, i9), typefaceA);
        }
        return typefaceA;
    }

    public static Typeface d(Context context, Resources resources, int i7, String str, int i8, int i9) {
        Typeface typefaceD = f2682a.d(context, resources, i7, str, i9);
        if (typefaceD != null) {
            f2683b.put(e(resources, i7, str, i8, i9), typefaceD);
        }
        return typefaceD;
    }

    public static String e(Resources resources, int i7, String str, int i8, int i9) {
        return resources.getResourcePackageName(i7) + '-' + str + '-' + i8 + '-' + i7 + '-' + i9;
    }

    public static Typeface f(Resources resources, int i7, String str, int i8, int i9) {
        return (Typeface) f2683b.get(e(resources, i7, str, i8, i9));
    }

    public static Typeface g(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Typeface typefaceCreate = Typeface.create(str, 0);
        Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
        if (typefaceCreate == null || typefaceCreate.equals(typefaceCreate2)) {
            return null;
        }
        return typefaceCreate;
    }
}
