package y;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: y.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1931f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f15821a = new ThreadLocal();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WeakHashMap f15822b = new WeakHashMap(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f15823c = new Object();

    /* JADX INFO: renamed from: y.f$a */
    public static class a {
        public static int a(Resources resources, int i4, Resources.Theme theme) {
            return resources.getColor(i4, theme);
        }

        public static ColorStateList b(Resources resources, int i4, Resources.Theme theme) {
            return resources.getColorStateList(i4, theme);
        }
    }

    /* JADX INFO: renamed from: y.f$b */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ColorStateList f15824a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Configuration f15825b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f15826c;

        public b(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
            this.f15824a = colorStateList;
            this.f15825b = configuration;
            this.f15826c = theme == null ? 0 : theme.hashCode();
        }
    }

    /* JADX INFO: renamed from: y.f$c */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Resources f15827a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Resources.Theme f15828b;

        public c(Resources resources, Resources.Theme theme) {
            this.f15827a = resources;
            this.f15828b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && c.class == obj.getClass()) {
                c cVar = (c) obj;
                if (this.f15827a.equals(cVar.f15827a) && G.b.a(this.f15828b, cVar.f15828b)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return G.b.b(this.f15827a, this.f15828b);
        }
    }

    /* JADX INFO: renamed from: y.f$d */
    public static abstract class d {
        public static Handler e(Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }

        public final void c(final int i4, Handler handler) {
            e(handler).post(new Runnable() { // from class: y.h
                @Override // java.lang.Runnable
                public final void run() {
                    this.f15831a.f(i4);
                }
            });
        }

        public final void d(final Typeface typeface, Handler handler) {
            e(handler).post(new Runnable() { // from class: y.g
                @Override // java.lang.Runnable
                public final void run() {
                    this.f15829a.g(typeface);
                }
            });
        }

        public abstract void f(int i4);

        public abstract void g(Typeface typeface);
    }

    public static void a(c cVar, int i4, ColorStateList colorStateList, Resources.Theme theme) {
        synchronized (f15823c) {
            try {
                WeakHashMap weakHashMap = f15822b;
                SparseArray sparseArray = (SparseArray) weakHashMap.get(cVar);
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    weakHashMap.put(cVar, sparseArray);
                }
                sparseArray.append(i4, new b(colorStateList, cVar.f15827a.getConfiguration(), theme));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
    
        if (r2.f15826c == r5.hashCode()) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.content.res.ColorStateList b(y.AbstractC1931f.c r5, int r6) {
        /*
            java.lang.Object r0 = y.AbstractC1931f.f15823c
            monitor-enter(r0)
            java.util.WeakHashMap r1 = y.AbstractC1931f.f15822b     // Catch: java.lang.Throwable -> L32
            java.lang.Object r1 = r1.get(r5)     // Catch: java.lang.Throwable -> L32
            android.util.SparseArray r1 = (android.util.SparseArray) r1     // Catch: java.lang.Throwable -> L32
            if (r1 == 0) goto L45
            int r2 = r1.size()     // Catch: java.lang.Throwable -> L32
            if (r2 <= 0) goto L45
            java.lang.Object r2 = r1.get(r6)     // Catch: java.lang.Throwable -> L32
            y.f$b r2 = (y.AbstractC1931f.b) r2     // Catch: java.lang.Throwable -> L32
            if (r2 == 0) goto L45
            android.content.res.Configuration r3 = r2.f15825b     // Catch: java.lang.Throwable -> L32
            android.content.res.Resources r4 = r5.f15827a     // Catch: java.lang.Throwable -> L32
            android.content.res.Configuration r4 = r4.getConfiguration()     // Catch: java.lang.Throwable -> L32
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Throwable -> L32
            if (r3 == 0) goto L42
            android.content.res.Resources$Theme r5 = r5.f15828b     // Catch: java.lang.Throwable -> L32
            if (r5 != 0) goto L34
            int r3 = r2.f15826c     // Catch: java.lang.Throwable -> L32
            if (r3 == 0) goto L3e
            goto L34
        L32:
            r5 = move-exception
            goto L48
        L34:
            if (r5 == 0) goto L42
            int r3 = r2.f15826c     // Catch: java.lang.Throwable -> L32
            int r5 = r5.hashCode()     // Catch: java.lang.Throwable -> L32
            if (r3 != r5) goto L42
        L3e:
            android.content.res.ColorStateList r5 = r2.f15824a     // Catch: java.lang.Throwable -> L32
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            return r5
        L42:
            r1.remove(r6)     // Catch: java.lang.Throwable -> L32
        L45:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            r5 = 0
            return r5
        L48:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: y.AbstractC1931f.b(y.f$c, int):android.content.res.ColorStateList");
    }

    public static ColorStateList c(Resources resources, int i4, Resources.Theme theme) {
        c cVar = new c(resources, theme);
        ColorStateList colorStateListB = b(cVar, i4);
        if (colorStateListB != null) {
            return colorStateListB;
        }
        ColorStateList colorStateListF = f(resources, i4, theme);
        if (colorStateListF == null) {
            return a.b(resources, i4, theme);
        }
        a(cVar, i4, colorStateListF, theme);
        return colorStateListF;
    }

    public static Typeface d(Context context, int i4, TypedValue typedValue, int i5, d dVar) {
        if (context.isRestricted()) {
            return null;
        }
        return h(context, i4, typedValue, i5, dVar, null, true, false);
    }

    public static TypedValue e() {
        ThreadLocal threadLocal = f15821a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    public static ColorStateList f(Resources resources, int i4, Resources.Theme theme) {
        if (g(resources, i4)) {
            return null;
        }
        try {
            return AbstractC1928c.a(resources, resources.getXml(i4), theme);
        } catch (Exception e4) {
            Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e4);
            return null;
        }
    }

    public static boolean g(Resources resources, int i4) {
        TypedValue typedValueE = e();
        resources.getValue(i4, typedValueE, true);
        int i5 = typedValueE.type;
        return i5 >= 28 && i5 <= 31;
    }

    public static Typeface h(Context context, int i4, TypedValue typedValue, int i5, d dVar, Handler handler, boolean z4, boolean z5) {
        Resources resources = context.getResources();
        resources.getValue(i4, typedValue, true);
        Typeface typefaceI = i(context, resources, typedValue, i4, i5, dVar, handler, z4, z5);
        if (typefaceI != null || dVar != null || z5) {
            return typefaceI;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i4) + " could not be retrieved.");
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Typeface i(android.content.Context r13, android.content.res.Resources r14, android.util.TypedValue r15, int r16, int r17, y.AbstractC1931f.d r18, android.os.Handler r19, boolean r20, boolean r21) {
        /*
            Method dump skipped, instruction units count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y.AbstractC1931f.i(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, y.f$d, android.os.Handler, boolean, boolean):android.graphics.Typeface");
    }
}
