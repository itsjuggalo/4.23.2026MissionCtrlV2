package z;

import E.g;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;
import u.C1859g;
import y.AbstractC1929d;

/* JADX INFO: renamed from: z.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1966e extends i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class f16034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Constructor f16035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Method f16036d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Method f16037e;

    static {
        Class<?> cls;
        Constructor<?> constructor;
        Method method;
        Method method2;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            constructor = cls.getConstructor(new Class[0]);
            Class cls2 = Integer.TYPE;
            method = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
        } catch (ClassNotFoundException | NoSuchMethodException e4) {
            Log.e("TypefaceCompatApi24Impl", e4.getClass().getName(), e4);
            cls = null;
            constructor = null;
            method = null;
            method2 = null;
        }
        f16035c = constructor;
        f16034b = cls;
        f16036d = method;
        f16037e = method2;
    }

    public static boolean h(Object obj, ByteBuffer byteBuffer, int i4, int i5, boolean z4) {
        try {
            return ((Boolean) f16036d.invoke(obj, byteBuffer, Integer.valueOf(i4), null, Integer.valueOf(i5), Boolean.valueOf(z4))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private static Typeface i(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) f16034b, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) f16037e.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static boolean j() {
        Method method = f16036d;
        if (method == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return method != null;
    }

    private static Object k() {
        try {
            return f16035c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // z.i
    public Typeface a(Context context, AbstractC1929d.c cVar, Resources resources, int i4) {
        Object objK = k();
        if (objK == null) {
            return null;
        }
        for (AbstractC1929d.C0257d c0257d : cVar.a()) {
            ByteBuffer byteBufferB = j.b(context, resources, c0257d.b());
            if (byteBufferB == null || !h(objK, byteBufferB, c0257d.c(), c0257d.e(), c0257d.f())) {
                return null;
            }
        }
        return i(objK);
    }

    @Override // z.i
    public Typeface b(Context context, CancellationSignal cancellationSignal, g.b[] bVarArr, int i4) {
        Object objK = k();
        if (objK == null) {
            return null;
        }
        C1859g c1859g = new C1859g();
        for (g.b bVar : bVarArr) {
            Uri uriD = bVar.d();
            ByteBuffer byteBufferF = (ByteBuffer) c1859g.get(uriD);
            if (byteBufferF == null) {
                byteBufferF = j.f(context, cancellationSignal, uriD);
                c1859g.put(uriD, byteBufferF);
            }
            if (byteBufferF == null || !h(objK, byteBufferF, bVar.c(), bVar.e(), bVar.f())) {
                return null;
            }
        }
        Typeface typefaceI = i(objK);
        if (typefaceI == null) {
            return null;
        }
        return Typeface.create(typefaceI, i4);
    }
}
