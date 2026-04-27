package L;

import K.d;
import K.f;
import Q.g;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f4927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final w.h f4928b;

    public static class a extends g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public f.e f4929a;

        public a(f.e eVar) {
            this.f4929a = eVar;
        }

        @Override // Q.g.c
        public void a(int i8) {
            f.e eVar = this.f4929a;
            if (eVar != null) {
                eVar.f(i8);
            }
        }

        @Override // Q.g.c
        public void b(Typeface typeface) {
            f.e eVar = this.f4929a;
            if (eVar != null) {
                eVar.g(typeface);
            }
        }
    }

    static {
        int i8 = Build.VERSION.SDK_INT;
        f4927a = i8 >= 29 ? new i() : i8 >= 28 ? new h() : i8 >= 26 ? new g() : f.j() ? new f() : new e();
        f4928b = new w.h(16);
    }

    public static Typeface a(Context context, Typeface typeface, int i8) {
        if (context != null) {
            return Typeface.create(typeface, i8);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface b(Context context, CancellationSignal cancellationSignal, g.b[] bVarArr, int i8) {
        return f4927a.b(context, cancellationSignal, bVarArr, i8);
    }

    public static Typeface c(Context context, d.b bVar, Resources resources, int i8, String str, int i9, int i10, f.e eVar, Handler handler, boolean z7) {
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
            typefaceA = Q.g.c(context, eVar2.b(), i10, !z7 ? eVar != null : eVar2.a() != 0, z7 ? eVar2.d() : -1, f.e.e(handler), new a(eVar));
        } else {
            typefaceA = f4927a.a(context, (d.c) bVar, resources, i10);
            if (eVar != null) {
                if (typefaceA != null) {
                    eVar.d(typefaceA, handler);
                } else {
                    eVar.c(-3, handler);
                }
            }
        }
        if (typefaceA != null) {
            f4928b.put(e(resources, i8, str, i9, i10), typefaceA);
        }
        return typefaceA;
    }

    public static Typeface d(Context context, Resources resources, int i8, String str, int i9, int i10) {
        Typeface typefaceD = f4927a.d(context, resources, i8, str, i10);
        if (typefaceD != null) {
            f4928b.put(e(resources, i8, str, i9, i10), typefaceD);
        }
        return typefaceD;
    }

    public static String e(Resources resources, int i8, String str, int i9, int i10) {
        return resources.getResourcePackageName(i8) + '-' + str + '-' + i9 + '-' + i8 + '-' + i10;
    }

    public static Typeface f(Resources resources, int i8, String str, int i9, int i10) {
        return (Typeface) f4928b.get(e(resources, i8, str, i9, i10));
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
