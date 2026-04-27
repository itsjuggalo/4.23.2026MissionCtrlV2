package H;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f2526a = new ThreadLocal();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WeakHashMap f2527b = new WeakHashMap(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f2528c = new Object();

    public static class a {
        public static Drawable a(Resources resources, int i7, Resources.Theme theme) {
            return resources.getDrawable(i7, theme);
        }

        public static Drawable b(Resources resources, int i7, int i8, Resources.Theme theme) {
            return resources.getDrawableForDensity(i7, i8, theme);
        }
    }

    public static class b {
        public static int a(Resources resources, int i7, Resources.Theme theme) {
            return resources.getColor(i7, theme);
        }

        public static ColorStateList b(Resources resources, int i7, Resources.Theme theme) {
            return resources.getColorStateList(i7, theme);
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ColorStateList f2529a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Configuration f2530b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f2531c;

        public c(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
            this.f2529a = colorStateList;
            this.f2530b = configuration;
            this.f2531c = theme == null ? 0 : theme.hashCode();
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Resources f2532a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Resources.Theme f2533b;

        public d(Resources resources, Resources.Theme theme) {
            this.f2532a = resources;
            this.f2533b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.f2532a.equals(dVar.f2532a) && P.b.a(this.f2533b, dVar.f2533b);
        }

        public int hashCode() {
            return P.b.b(this.f2532a, this.f2533b);
        }
    }

    public static abstract class e {
        public static Handler e(Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }

        public final void c(final int i7, Handler handler) {
            e(handler).post(new Runnable() { // from class: H.h
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2536a.f(i7);
                }
            });
        }

        public final void d(final Typeface typeface, Handler handler) {
            e(handler).post(new Runnable() { // from class: H.g
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2534a.g(typeface);
                }
            });
        }

        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public abstract void f(int i7);

        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public abstract void g(Typeface typeface);
    }

    public static void a(d dVar, int i7, ColorStateList colorStateList, Resources.Theme theme) {
        synchronized (f2528c) {
            try {
                WeakHashMap weakHashMap = f2527b;
                SparseArray sparseArray = (SparseArray) weakHashMap.get(dVar);
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    weakHashMap.put(dVar, sparseArray);
                }
                sparseArray.append(i7, new c(colorStateList, dVar.f2532a.getConfiguration(), theme));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
    
        if (r2.f2531c == r5.hashCode()) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.content.res.ColorStateList b(H.f.d r5, int r6) {
        /*
            java.lang.Object r0 = H.f.f2528c
            monitor-enter(r0)
            java.util.WeakHashMap r1 = H.f.f2527b     // Catch: java.lang.Throwable -> L32
            java.lang.Object r1 = r1.get(r5)     // Catch: java.lang.Throwable -> L32
            android.util.SparseArray r1 = (android.util.SparseArray) r1     // Catch: java.lang.Throwable -> L32
            if (r1 == 0) goto L45
            int r2 = r1.size()     // Catch: java.lang.Throwable -> L32
            if (r2 <= 0) goto L45
            java.lang.Object r2 = r1.get(r6)     // Catch: java.lang.Throwable -> L32
            H.f$c r2 = (H.f.c) r2     // Catch: java.lang.Throwable -> L32
            if (r2 == 0) goto L45
            android.content.res.Configuration r3 = r2.f2530b     // Catch: java.lang.Throwable -> L32
            android.content.res.Resources r4 = r5.f2532a     // Catch: java.lang.Throwable -> L32
            android.content.res.Configuration r4 = r4.getConfiguration()     // Catch: java.lang.Throwable -> L32
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Throwable -> L32
            if (r3 == 0) goto L42
            android.content.res.Resources$Theme r5 = r5.f2533b     // Catch: java.lang.Throwable -> L32
            if (r5 != 0) goto L34
            int r3 = r2.f2531c     // Catch: java.lang.Throwable -> L32
            if (r3 == 0) goto L3e
            goto L34
        L32:
            r5 = move-exception
            goto L48
        L34:
            if (r5 == 0) goto L42
            int r3 = r2.f2531c     // Catch: java.lang.Throwable -> L32
            int r5 = r5.hashCode()     // Catch: java.lang.Throwable -> L32
            if (r3 != r5) goto L42
        L3e:
            android.content.res.ColorStateList r5 = r2.f2529a     // Catch: java.lang.Throwable -> L32
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
        throw new UnsupportedOperationException("Method not decompiled: H.f.b(H.f$d, int):android.content.res.ColorStateList");
    }

    public static Typeface c(Context context, int i7) {
        if (context.isRestricted()) {
            return null;
        }
        return m(context, i7, new TypedValue(), 0, null, null, false, true);
    }

    public static ColorStateList d(Resources resources, int i7, Resources.Theme theme) {
        d dVar = new d(resources, theme);
        ColorStateList colorStateListB = b(dVar, i7);
        if (colorStateListB != null) {
            return colorStateListB;
        }
        ColorStateList colorStateListK = k(resources, i7, theme);
        if (colorStateListK == null) {
            return b.b(resources, i7, theme);
        }
        a(dVar, i7, colorStateListK, theme);
        return colorStateListK;
    }

    public static Drawable e(Resources resources, int i7, Resources.Theme theme) {
        return a.a(resources, i7, theme);
    }

    public static Drawable f(Resources resources, int i7, int i8, Resources.Theme theme) {
        return a.b(resources, i7, i8, theme);
    }

    public static Typeface g(Context context, int i7) {
        if (context.isRestricted()) {
            return null;
        }
        return m(context, i7, new TypedValue(), 0, null, null, false, false);
    }

    public static Typeface h(Context context, int i7, TypedValue typedValue, int i8, e eVar) {
        if (context.isRestricted()) {
            return null;
        }
        return m(context, i7, typedValue, i8, eVar, null, true, false);
    }

    public static void i(Context context, int i7, e eVar, Handler handler) {
        P.f.g(eVar);
        if (context.isRestricted()) {
            eVar.c(-4, handler);
        } else {
            m(context, i7, new TypedValue(), 0, eVar, handler, false, false);
        }
    }

    public static TypedValue j() {
        ThreadLocal threadLocal = f2526a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    public static ColorStateList k(Resources resources, int i7, Resources.Theme theme) {
        if (l(resources, i7)) {
            return null;
        }
        try {
            return H.c.a(resources, resources.getXml(i7), theme);
        } catch (Exception e7) {
            Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e7);
            return null;
        }
    }

    public static boolean l(Resources resources, int i7) {
        TypedValue typedValueJ = j();
        resources.getValue(i7, typedValueJ, true);
        int i8 = typedValueJ.type;
        return i8 >= 28 && i8 <= 31;
    }

    public static Typeface m(Context context, int i7, TypedValue typedValue, int i8, e eVar, Handler handler, boolean z7, boolean z8) {
        Resources resources = context.getResources();
        resources.getValue(i7, typedValue, true);
        Typeface typefaceN = n(context, resources, typedValue, i7, i8, eVar, handler, z7, z8);
        if (typefaceN != null || eVar != null || z8) {
            return typefaceN;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i7) + " could not be retrieved.");
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Typeface n(android.content.Context r16, android.content.res.Resources r17, android.util.TypedValue r18, int r19, int r20, H.f.e r21, android.os.Handler r22, boolean r23, boolean r24) {
        /*
            Method dump skipped, instruction units count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: H.f.n(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, H.f$e, android.os.Handler, boolean, boolean):android.graphics.Typeface");
    }
}
