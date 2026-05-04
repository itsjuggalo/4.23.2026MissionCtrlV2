package l0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import java.util.List;
import k0.d;
import k0.f;
import q0.g;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f14965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final w.h f14966b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public f.e f14967a;

        public a(f.e eVar) {
            this.f14967a = eVar;
        }

        @Override // q0.g.c
        public void a(int i10) {
            f.e eVar = this.f14967a;
            if (eVar != null) {
                eVar.f(i10);
            }
        }

        @Override // q0.g.c
        public void b(Typeface typeface) {
            f.e eVar = this.f14967a;
            if (eVar != null) {
                eVar.g(typeface);
            }
        }
    }

    static {
        m2.a.c("TypefaceCompat static init");
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29) {
            f14965a = new l();
        } else if (i10 >= 28) {
            f14965a = new k();
        } else if (i10 >= 26) {
            f14965a = new j();
        } else if (i.k()) {
            f14965a = new i();
        } else {
            f14965a = new h();
        }
        f14966b = new w.h(16);
        m2.a.f();
    }

    public static Typeface a(Context context, Typeface typeface, int i10) {
        if (context != null) {
            return Typeface.create(typeface, i10);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface b(Context context, CancellationSignal cancellationSignal, g.b[] bVarArr, int i10) {
        m2.a.c("TypefaceCompat.createFromFontInfo");
        try {
            return f14965a.b(context, cancellationSignal, bVarArr, i10);
        } finally {
            m2.a.f();
        }
    }

    public static Typeface c(Context context, CancellationSignal cancellationSignal, List list, int i10) {
        m2.a.c("TypefaceCompat.createFromFontInfoWithFallback");
        try {
            return f14965a.c(context, cancellationSignal, list, i10);
        } finally {
            m2.a.f();
        }
    }

    public static Typeface d(Context context, d.b bVar, Resources resources, int i10, String str, int i11, int i12, f.e eVar, Handler handler, boolean z10) {
        Typeface typefaceA;
        if (bVar instanceof d.e) {
            d.e eVar2 = (d.e) bVar;
            Typeface typefaceH = h(eVar2.d());
            if (typefaceH != null) {
                if (eVar != null) {
                    eVar.d(typefaceH, handler);
                }
                return typefaceH;
            }
            typefaceA = q0.g.c(context, eVar2.a() != null ? f.a(new Object[]{eVar2.c(), eVar2.a()}) : f.a(new Object[]{eVar2.c()}), i12, !z10 ? eVar != null : eVar2.b() != 0, z10 ? eVar2.e() : -1, f.e.e(handler), new a(eVar));
        } else {
            typefaceA = f14965a.a(context, (d.c) bVar, resources, i12);
            if (eVar != null) {
                if (typefaceA != null) {
                    eVar.d(typefaceA, handler);
                } else {
                    eVar.c(-3, handler);
                }
            }
        }
        if (typefaceA != null) {
            f14966b.put(f(resources, i10, str, i11, i12), typefaceA);
        }
        return typefaceA;
    }

    public static Typeface e(Context context, Resources resources, int i10, String str, int i11, int i12) {
        Typeface typefaceE = f14965a.e(context, resources, i10, str, i12);
        if (typefaceE != null) {
            f14966b.put(f(resources, i10, str, i11, i12), typefaceE);
        }
        return typefaceE;
    }

    public static String f(Resources resources, int i10, String str, int i11, int i12) {
        return resources.getResourcePackageName(i10) + '-' + str + '-' + i11 + '-' + i10 + '-' + i12;
    }

    public static Typeface g(Resources resources, int i10, String str, int i11, int i12) {
        return (Typeface) f14966b.get(f(resources, i10, str, i11, i12));
    }

    public static Typeface h(String str) {
        if (str != null && !str.isEmpty()) {
            Typeface typefaceCreate = Typeface.create(str, 0);
            Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
            if (typefaceCreate != null && !typefaceCreate.equals(typefaceCreate2)) {
                return typefaceCreate;
            }
        }
        return null;
    }
}
