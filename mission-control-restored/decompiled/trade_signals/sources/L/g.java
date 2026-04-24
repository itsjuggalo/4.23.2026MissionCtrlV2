package L;

import K.d;
import Q.g;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class g extends e {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Class f4939g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Constructor f4940h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Method f4941i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Method f4942j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Method f4943k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Method f4944l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Method f4945m;

    public g() {
        Class clsV;
        Constructor constructorW;
        Method methodS;
        Method methodT;
        Method methodX;
        Method methodR;
        Method methodU;
        try {
            clsV = v();
            constructorW = w(clsV);
            methodS = s(clsV);
            methodT = t(clsV);
            methodX = x(clsV);
            methodR = r(clsV);
            methodU = u(clsV);
        } catch (ClassNotFoundException | NoSuchMethodException e8) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e8.getClass().getName(), e8);
            clsV = null;
            constructorW = null;
            methodS = null;
            methodT = null;
            methodX = null;
            methodR = null;
            methodU = null;
        }
        this.f4939g = clsV;
        this.f4940h = constructorW;
        this.f4941i = methodS;
        this.f4942j = methodT;
        this.f4943k = methodX;
        this.f4944l = methodR;
        this.f4945m = methodU;
    }

    @Override // L.e, L.j
    public Typeface a(Context context, d.c cVar, Resources resources, int i8) {
        if (!q()) {
            return super.a(context, cVar, resources, i8);
        }
        Object objL = l();
        if (objL == null) {
            return null;
        }
        for (d.C0065d c0065d : cVar.a()) {
            if (!n(context, objL, c0065d.a(), c0065d.c(), c0065d.e(), c0065d.f() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(c0065d.d()))) {
                m(objL);
                return null;
            }
        }
        if (p(objL)) {
            return i(objL);
        }
        return null;
    }

    @Override // L.e, L.j
    public Typeface b(Context context, CancellationSignal cancellationSignal, g.b[] bVarArr, int i8) {
        Typeface typefaceI;
        if (bVarArr.length < 1) {
            return null;
        }
        if (!q()) {
            g.b bVarG = g(bVarArr, i8);
            try {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(bVarG.d(), "r", cancellationSignal);
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    }
                    return null;
                }
                try {
                    Typeface typefaceBuild = new Typeface.Builder(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()).setWeight(bVarG.e()).setItalic(bVarG.f()).build();
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return typefaceBuild;
                } finally {
                }
            } catch (IOException unused) {
                return null;
            }
        }
        Map mapH = k.h(context, bVarArr, cancellationSignal);
        Object objL = l();
        if (objL == null) {
            return null;
        }
        boolean z7 = false;
        for (g.b bVar : bVarArr) {
            ByteBuffer byteBuffer = (ByteBuffer) mapH.get(bVar.d());
            if (byteBuffer != null) {
                if (!o(objL, byteBuffer, bVar.c(), bVar.e(), bVar.f() ? 1 : 0)) {
                    m(objL);
                    return null;
                }
                z7 = true;
            }
        }
        if (!z7) {
            m(objL);
            return null;
        }
        if (p(objL) && (typefaceI = i(objL)) != null) {
            return Typeface.create(typefaceI, i8);
        }
        return null;
    }

    @Override // L.j
    public Typeface d(Context context, Resources resources, int i8, String str, int i9) {
        if (!q()) {
            return super.d(context, resources, i8, str, i9);
        }
        Object objL = l();
        if (objL == null) {
            return null;
        }
        if (!n(context, objL, str, 0, -1, -1, null)) {
            m(objL);
            return null;
        }
        if (p(objL)) {
            return i(objL);
        }
        return null;
    }

    public Typeface i(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) this.f4939g, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.f4945m.invoke(null, objNewInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final Object l() {
        try {
            return this.f4940h.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    public final void m(Object obj) {
        try {
            this.f4944l.invoke(obj, null);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    public final boolean n(Context context, Object obj, String str, int i8, int i9, int i10, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f4941i.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean o(Object obj, ByteBuffer byteBuffer, int i8, int i9, int i10) {
        try {
            return ((Boolean) this.f4942j.invoke(obj, byteBuffer, Integer.valueOf(i8), null, Integer.valueOf(i9), Integer.valueOf(i10))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean p(Object obj) {
        try {
            return ((Boolean) this.f4943k.invoke(obj, null)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean q() {
        if (this.f4941i == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.f4941i != null;
    }

    public Method r(Class cls) {
        return cls.getMethod("abortCreation", null);
    }

    public Method s(Class cls) {
        Class cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    public Method t(Class cls) {
        Class cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
    }

    public Method u(Class cls) throws NoSuchMethodException {
        Class<?> cls2 = Array.newInstance((Class<?>) cls, 1).getClass();
        Class cls3 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", cls2, cls3, cls3);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    public Class v() {
        return Class.forName("android.graphics.FontFamily");
    }

    public Constructor w(Class cls) {
        return cls.getConstructor(null);
    }

    public Method x(Class cls) {
        return cls.getMethod("freeze", null);
    }
}
