package z;

import E.g;
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
import y.AbstractC1929d;

/* JADX INFO: renamed from: z.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1967f extends C1965d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Class f16038g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Constructor f16039h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Method f16040i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Method f16041j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Method f16042k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Method f16043l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Method f16044m;

    public C1967f() {
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
        } catch (ClassNotFoundException | NoSuchMethodException e4) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e4.getClass().getName(), e4);
            clsV = null;
            constructorW = null;
            methodS = null;
            methodT = null;
            methodX = null;
            methodR = null;
            methodU = null;
        }
        this.f16038g = clsV;
        this.f16039h = constructorW;
        this.f16040i = methodS;
        this.f16041j = methodT;
        this.f16042k = methodX;
        this.f16043l = methodR;
        this.f16044m = methodU;
    }

    @Override // z.C1965d, z.i
    public Typeface a(Context context, AbstractC1929d.c cVar, Resources resources, int i4) {
        if (!q()) {
            return super.a(context, cVar, resources, i4);
        }
        Object objL = l();
        if (objL == null) {
            return null;
        }
        AbstractC1929d.C0257d[] c0257dArrA = cVar.a();
        int length = c0257dArrA.length;
        int i5 = 0;
        while (i5 < length) {
            AbstractC1929d.C0257d c0257d = c0257dArrA[i5];
            Context context2 = context;
            if (!n(context2, objL, c0257d.a(), c0257d.c(), c0257d.e(), c0257d.f() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(c0257d.d()))) {
                m(objL);
                return null;
            }
            i5++;
            context = context2;
        }
        if (p(objL)) {
            return i(objL);
        }
        return null;
    }

    @Override // z.C1965d, z.i
    public Typeface b(Context context, CancellationSignal cancellationSignal, g.b[] bVarArr, int i4) {
        Typeface typefaceI;
        Object obj;
        if (bVarArr.length < 1) {
            return null;
        }
        if (q()) {
            Map mapH = j.h(context, bVarArr, cancellationSignal);
            Object objL = l();
            if (objL == null) {
                return null;
            }
            int length = bVarArr.length;
            int i5 = 0;
            boolean z4 = false;
            while (i5 < length) {
                g.b bVar = bVarArr[i5];
                ByteBuffer byteBuffer = (ByteBuffer) mapH.get(bVar.d());
                if (byteBuffer == null) {
                    obj = objL;
                } else {
                    boolean zO = o(objL, byteBuffer, bVar.c(), bVar.e(), bVar.f() ? 1 : 0);
                    obj = objL;
                    if (!zO) {
                        m(obj);
                        return null;
                    }
                    z4 = true;
                }
                i5++;
                objL = obj;
                z4 = z4;
            }
            Object obj2 = objL;
            if (!z4) {
                m(obj2);
                return null;
            }
            if (p(obj2) && (typefaceI = i(obj2)) != null) {
                return Typeface.create(typefaceI, i4);
            }
            return null;
        }
        g.b bVarG = g(bVarArr, i4);
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

    @Override // z.i
    public Typeface d(Context context, Resources resources, int i4, String str, int i5) {
        if (!q()) {
            return super.d(context, resources, i4, str, i5);
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
            Object objNewInstance = Array.newInstance((Class<?>) this.f16038g, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.f16044m.invoke(null, objNewInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final Object l() {
        try {
            return this.f16039h.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    public final void m(Object obj) {
        try {
            this.f16043l.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    public final boolean n(Context context, Object obj, String str, int i4, int i5, int i6, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f16040i.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean o(Object obj, ByteBuffer byteBuffer, int i4, int i5, int i6) {
        try {
            return ((Boolean) this.f16041j.invoke(obj, byteBuffer, Integer.valueOf(i4), null, Integer.valueOf(i5), Integer.valueOf(i6))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean p(Object obj) {
        try {
            return ((Boolean) this.f16042k.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean q() {
        if (this.f16040i == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.f16040i != null;
    }

    public Method r(Class cls) {
        return cls.getMethod("abortCreation", new Class[0]);
    }

    public Method s(Class cls) {
        Class cls2 = Boolean.TYPE;
        Class cls3 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls3, cls2, cls3, cls3, cls3, FontVariationAxis[].class);
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
        return cls.getConstructor(new Class[0]);
    }

    public Method x(Class cls) {
        return cls.getMethod("freeze", new Class[0]);
    }
}
