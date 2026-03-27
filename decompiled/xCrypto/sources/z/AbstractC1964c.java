package z;

import E.g;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import u.C1857e;
import y.AbstractC1929d;
import y.AbstractC1931f;

/* JADX INFO: renamed from: z.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1964c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f16026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C1857e f16027b;

    /* JADX INFO: renamed from: z.c$a */
    public static class a extends g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AbstractC1931f.d f16028a;

        public a(AbstractC1931f.d dVar) {
            this.f16028a = dVar;
        }

        @Override // E.g.c
        public void a(int i4) {
            AbstractC1931f.d dVar = this.f16028a;
            if (dVar != null) {
                dVar.f(i4);
            }
        }

        @Override // E.g.c
        public void b(Typeface typeface) {
            AbstractC1931f.d dVar = this.f16028a;
            if (dVar != null) {
                dVar.g(typeface);
            }
        }
    }

    static {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 29) {
            f16026a = new h();
        } else if (i4 >= 28) {
            f16026a = new C1968g();
        } else if (i4 >= 26) {
            f16026a = new C1967f();
        } else if (C1966e.j()) {
            f16026a = new C1966e();
        } else {
            f16026a = new C1965d();
        }
        f16027b = new C1857e(16);
    }

    public static Typeface a(Context context, Typeface typeface, int i4) {
        if (context != null) {
            return Typeface.create(typeface, i4);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface b(Context context, CancellationSignal cancellationSignal, g.b[] bVarArr, int i4) {
        return f16026a.b(context, cancellationSignal, bVarArr, i4);
    }

    public static Typeface c(Context context, AbstractC1929d.b bVar, Resources resources, int i4, String str, int i5, int i6, AbstractC1931f.d dVar, Handler handler, boolean z4) {
        Typeface typefaceA;
        if (bVar instanceof AbstractC1929d.e) {
            AbstractC1929d.e eVar = (AbstractC1929d.e) bVar;
            Typeface typefaceG = g(eVar.c());
            if (typefaceG != null) {
                if (dVar != null) {
                    dVar.d(typefaceG, handler);
                }
                return typefaceG;
            }
            typefaceA = E.g.a(context, eVar.b(), i6, !z4 ? dVar != null : eVar.a() != 0, z4 ? eVar.d() : -1, AbstractC1931f.d.e(handler), new a(dVar));
        } else {
            typefaceA = f16026a.a(context, (AbstractC1929d.c) bVar, resources, i6);
            if (dVar != null) {
                if (typefaceA != null) {
                    dVar.d(typefaceA, handler);
                } else {
                    dVar.c(-3, handler);
                }
            }
        }
        if (typefaceA != null) {
            f16027b.put(e(resources, i4, str, i5, i6), typefaceA);
        }
        return typefaceA;
    }

    public static Typeface d(Context context, Resources resources, int i4, String str, int i5, int i6) {
        Typeface typefaceD = f16026a.d(context, resources, i4, str, i6);
        if (typefaceD != null) {
            f16027b.put(e(resources, i4, str, i5, i6), typefaceD);
        }
        return typefaceD;
    }

    public static String e(Resources resources, int i4, String str, int i5, int i6) {
        return resources.getResourcePackageName(i4) + '-' + str + '-' + i5 + '-' + i4 + '-' + i6;
    }

    public static Typeface f(Resources resources, int i4, String str, int i5, int i6) {
        return (Typeface) f16027b.get(e(resources, i4, str, i5, i6));
    }

    public static Typeface g(String str) {
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
