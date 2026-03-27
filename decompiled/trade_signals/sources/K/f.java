package K;

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
    public static final ThreadLocal f4707a = new ThreadLocal();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WeakHashMap f4708b = new WeakHashMap(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f4709c = new Object();

    public static class a {
        public static Drawable a(Resources resources, int i8, Resources.Theme theme) {
            return resources.getDrawable(i8, theme);
        }

        public static Drawable b(Resources resources, int i8, int i9, Resources.Theme theme) {
            return resources.getDrawableForDensity(i8, i9, theme);
        }
    }

    public static class b {
        public static int a(Resources resources, int i8, Resources.Theme theme) {
            return resources.getColor(i8, theme);
        }

        public static ColorStateList b(Resources resources, int i8, Resources.Theme theme) {
            return resources.getColorStateList(i8, theme);
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ColorStateList f4710a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Configuration f4711b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f4712c;

        public c(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
            this.f4710a = colorStateList;
            this.f4711b = configuration;
            this.f4712c = theme == null ? 0 : theme.hashCode();
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Resources f4713a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Resources.Theme f4714b;

        public d(Resources resources, Resources.Theme theme) {
            this.f4713a = resources;
            this.f4714b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.f4713a.equals(dVar.f4713a) && S.c.a(this.f4714b, dVar.f4714b);
        }

        public int hashCode() {
            return S.c.b(this.f4713a, this.f4714b);
        }
    }

    public static abstract class e {
        public static Handler e(Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }

        public final void c(final int i8, Handler handler) {
            e(handler).post(new Runnable() { // from class: K.h
                @Override // java.lang.Runnable
                public final void run() {
                    this.f4717a.f(i8);
                }
            });
        }

        public final void d(final Typeface typeface, Handler handler) {
            e(handler).post(new Runnable() { // from class: K.g
                @Override // java.lang.Runnable
                public final void run() {
                    this.f4715a.g(typeface);
                }
            });
        }

        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public abstract void f(int i8);

        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public abstract void g(Typeface typeface);
    }

    public static void a(d dVar, int i8, ColorStateList colorStateList, Resources.Theme theme) {
        synchronized (f4709c) {
            try {
                WeakHashMap weakHashMap = f4708b;
                SparseArray sparseArray = (SparseArray) weakHashMap.get(dVar);
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    weakHashMap.put(dVar, sparseArray);
                }
                sparseArray.append(i8, new c(colorStateList, dVar.f4713a.getConfiguration(), theme));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
    
        if (r2.f4712c == r5.hashCode()) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.content.res.ColorStateList b(K.f.d r5, int r6) {
        /*
            java.lang.Object r0 = K.f.f4709c
            monitor-enter(r0)
            java.util.WeakHashMap r1 = K.f.f4708b     // Catch: java.lang.Throwable -> L32
            java.lang.Object r1 = r1.get(r5)     // Catch: java.lang.Throwable -> L32
            android.util.SparseArray r1 = (android.util.SparseArray) r1     // Catch: java.lang.Throwable -> L32
            if (r1 == 0) goto L45
            int r2 = r1.size()     // Catch: java.lang.Throwable -> L32
            if (r2 <= 0) goto L45
            java.lang.Object r2 = r1.get(r6)     // Catch: java.lang.Throwable -> L32
            K.f$c r2 = (K.f.c) r2     // Catch: java.lang.Throwable -> L32
            if (r2 == 0) goto L45
            android.content.res.Configuration r3 = r2.f4711b     // Catch: java.lang.Throwable -> L32
            android.content.res.Resources r4 = r5.f4713a     // Catch: java.lang.Throwable -> L32
            android.content.res.Configuration r4 = r4.getConfiguration()     // Catch: java.lang.Throwable -> L32
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Throwable -> L32
            if (r3 == 0) goto L42
            android.content.res.Resources$Theme r5 = r5.f4714b     // Catch: java.lang.Throwable -> L32
            if (r5 != 0) goto L34
            int r3 = r2.f4712c     // Catch: java.lang.Throwable -> L32
            if (r3 == 0) goto L3e
            goto L34
        L32:
            r5 = move-exception
            goto L48
        L34:
            if (r5 == 0) goto L42
            int r3 = r2.f4712c     // Catch: java.lang.Throwable -> L32
            int r5 = r5.hashCode()     // Catch: java.lang.Throwable -> L32
            if (r3 != r5) goto L42
        L3e:
            android.content.res.ColorStateList r5 = r2.f4710a     // Catch: java.lang.Throwable -> L32
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
        throw new UnsupportedOperationException("Method not decompiled: K.f.b(K.f$d, int):android.content.res.ColorStateList");
    }

    public static ColorStateList c(Resources resources, int i8, Resources.Theme theme) {
        d dVar = new d(resources, theme);
        ColorStateList colorStateListB = b(dVar, i8);
        if (colorStateListB != null) {
            return colorStateListB;
        }
        ColorStateList colorStateListH = h(resources, i8, theme);
        if (colorStateListH == null) {
            return b.b(resources, i8, theme);
        }
        a(dVar, i8, colorStateListH, theme);
        return colorStateListH;
    }

    public static Drawable d(Resources resources, int i8, Resources.Theme theme) {
        return a.a(resources, i8, theme);
    }

    public static Drawable e(Resources resources, int i8, int i9, Resources.Theme theme) {
        return a.b(resources, i8, i9, theme);
    }

    public static Typeface f(Context context, int i8, TypedValue typedValue, int i9, e eVar) {
        if (context.isRestricted()) {
            return null;
        }
        return j(context, i8, typedValue, i9, eVar, null, true, false);
    }

    public static TypedValue g() {
        ThreadLocal threadLocal = f4707a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    public static ColorStateList h(Resources resources, int i8, Resources.Theme theme) {
        if (i(resources, i8)) {
            return null;
        }
        try {
            return K.c.a(resources, resources.getXml(i8), theme);
        } catch (Exception e8) {
            Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e8);
            return null;
        }
    }

    public static boolean i(Resources resources, int i8) {
        TypedValue typedValueG = g();
        resources.getValue(i8, typedValueG, true);
        int i9 = typedValueG.type;
        return i9 >= 28 && i9 <= 31;
    }

    public static Typeface j(Context context, int i8, TypedValue typedValue, int i9, e eVar, Handler handler, boolean z7, boolean z8) {
        Resources resources = context.getResources();
        resources.getValue(i8, typedValue, true);
        Typeface typefaceK = k(context, resources, typedValue, i8, i9, eVar, handler, z7, z8);
        if (typefaceK != null || eVar != null || z8) {
            return typefaceK;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i8) + " could not be retrieved.");
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Typeface k(android.content.Context r16, android.content.res.Resources r17, android.util.TypedValue r18, int r19, int r20, K.f.e r21, android.os.Handler r22, boolean r23, boolean r24) {
        /*
            Method dump skipped, instruction units count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: K.f.k(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, K.f$e, android.os.Handler, boolean, boolean):android.graphics.Typeface");
    }
}
