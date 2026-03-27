package L;

import K.d;
import Q.g;
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

/* JADX INFO: loaded from: classes.dex */
public class f extends j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class f4935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Constructor f4936c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Method f4937d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Method f4938e;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            Class cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e8) {
            Log.e("TypefaceCompatApi24Impl", e8.getClass().getName(), e8);
            cls = null;
            method = null;
            method2 = null;
        }
        f4936c = constructor;
        f4935b = cls;
        f4937d = method2;
        f4938e = method;
    }

    public static boolean h(Object obj, ByteBuffer byteBuffer, int i8, int i9, boolean z7) {
        try {
            return ((Boolean) f4937d.invoke(obj, byteBuffer, Integer.valueOf(i8), null, Integer.valueOf(i9), Boolean.valueOf(z7))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private static Typeface i(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) f4935b, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) f4938e.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static boolean j() {
        Method method = f4937d;
        if (method == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return method != null;
    }

    private static Object k() {
        try {
            return f4936c.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // L.j
    public Typeface a(Context context, d.c cVar, Resources resources, int i8) {
        Object objK = k();
        if (objK == null) {
            return null;
        }
        for (d.C0065d c0065d : cVar.a()) {
            ByteBuffer byteBufferB = k.b(context, resources, c0065d.b());
            if (byteBufferB == null || !h(objK, byteBufferB, c0065d.c(), c0065d.e(), c0065d.f())) {
                return null;
            }
        }
        return i(objK);
    }

    @Override // L.j
    public Typeface b(Context context, CancellationSignal cancellationSignal, g.b[] bVarArr, int i8) {
        Object objK = k();
        if (objK == null) {
            return null;
        }
        w.i iVar = new w.i();
        for (g.b bVar : bVarArr) {
            Uri uriD = bVar.d();
            ByteBuffer byteBufferF = (ByteBuffer) iVar.get(uriD);
            if (byteBufferF == null) {
                byteBufferF = k.f(context, cancellationSignal, uriD);
                iVar.put(uriD, byteBufferF);
            }
            if (byteBufferF == null || !h(objK, byteBufferF, bVar.c(), bVar.e(), bVar.f())) {
                return null;
            }
        }
        Typeface typefaceI = i(objK);
        if (typefaceI == null) {
            return null;
        }
        return Typeface.create(typefaceI, i8);
    }
}
