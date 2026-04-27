package w;

import A.l;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: w.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1270i extends C1268g {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Class f10691m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Constructor f10692n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Method f10693o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Method f10694p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Method f10695q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Method f10696r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Method f10697s;

    public C1270i() {
        Class<?> cls;
        Method method;
        Constructor<?> constructor;
        Method methodV;
        Method method2;
        Method method3;
        Method methodW;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            constructor = cls.getConstructor(new Class[0]);
            methodV = V(cls);
            Class cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
            method3 = cls.getMethod("freeze", new Class[0]);
            method = cls.getMethod("abortCreation", new Class[0]);
            methodW = W(cls);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class ".concat(e.getClass().getName()), e);
            cls = null;
            method = null;
            constructor = null;
            methodV = null;
            method2 = null;
            method3 = null;
            methodW = null;
        }
        this.f10691m = cls;
        this.f10692n = constructor;
        this.f10693o = methodV;
        this.f10694p = method2;
        this.f10695q = method3;
        this.f10696r = method;
        this.f10697s = methodW;
    }

    public static Method V(Class cls) {
        Class cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    public final void Q(Object obj) {
        try {
            this.f10696r.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    public final boolean R(Context context, Object obj, String str, int i, int i6, int i7, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f10693o.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i), Integer.valueOf(i6), Integer.valueOf(i7), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Typeface S(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) this.f10691m, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.f10697s.invoke(null, objNewInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean T(Object obj) {
        try {
            return ((Boolean) this.f10695q.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final Object U() {
        try {
            return this.f10692n.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    public Method W(Class cls) throws NoSuchMethodException {
        Class<?> cls2 = Array.newInstance((Class<?>) cls, 1).getClass();
        Class cls3 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", cls2, cls3, cls3);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    @Override // w.C1268g, D1.b
    public final Typeface h(Context context, v.f fVar, Resources resources, int i) {
        Method method = this.f10693o;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (method == null) {
            return super.h(context, fVar, resources, i);
        }
        Object objU = U();
        if (objU != null) {
            v.g[] gVarArr = fVar.f10574a;
            int length = gVarArr.length;
            int i6 = 0;
            while (i6 < length) {
                v.g gVar = gVarArr[i6];
                String str = gVar.f10575a;
                FontVariationAxis[] fontVariationAxisArrFromFontVariationSettings = FontVariationAxis.fromFontVariationSettings(gVar.f10578d);
                Context context2 = context;
                if (!R(context2, objU, str, gVar.e, gVar.f10576b, gVar.f10577c ? 1 : 0, fontVariationAxisArrFromFontVariationSettings)) {
                    Q(objU);
                    return null;
                }
                i6++;
                context = context2;
            }
            if (T(objU)) {
                return S(objU);
            }
        }
        return null;
    }

    @Override // w.C1268g, D1.b
    public final Typeface i(Context context, l[] lVarArr, int i) {
        Typeface typefaceS;
        boolean zBooleanValue;
        if (lVarArr.length >= 1) {
            Method method = this.f10693o;
            if (method == null) {
                Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
            }
            if (method != null) {
                HashMap map = new HashMap();
                for (l lVar : lVarArr) {
                    if (lVar.e == 0) {
                        Uri uri = lVar.f31a;
                        if (!map.containsKey(uri)) {
                            map.put(uri, F1.h.G(context, uri));
                        }
                    }
                }
                Map mapUnmodifiableMap = Collections.unmodifiableMap(map);
                Object objU = U();
                if (objU != null) {
                    int length = lVarArr.length;
                    int i6 = 0;
                    boolean z6 = false;
                    while (i6 < length) {
                        l lVar2 = lVarArr[i6];
                        ByteBuffer byteBuffer = (ByteBuffer) mapUnmodifiableMap.get(lVar2.f31a);
                        if (byteBuffer != null) {
                            try {
                                zBooleanValue = ((Boolean) this.f10694p.invoke(objU, byteBuffer, Integer.valueOf(lVar2.f32b), null, Integer.valueOf(lVar2.f33c), Integer.valueOf(lVar2.f34d ? 1 : 0))).booleanValue();
                            } catch (IllegalAccessException | InvocationTargetException unused) {
                                zBooleanValue = false;
                            }
                            if (!zBooleanValue) {
                                Q(objU);
                                return null;
                            }
                            z6 = true;
                        }
                        i6++;
                        z6 = z6;
                    }
                    if (!z6) {
                        Q(objU);
                        return null;
                    }
                    if (T(objU) && (typefaceS = S(objU)) != null) {
                        return Typeface.create(typefaceS, i);
                    }
                }
            } else {
                l lVarO = o(lVarArr, i);
                try {
                    ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(lVarO.f31a, "r", null);
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        try {
                            Typeface typefaceBuild = new Typeface.Builder(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()).setWeight(lVarO.f33c).setItalic(lVarO.f34d).build();
                            parcelFileDescriptorOpenFileDescriptor.close();
                            return typefaceBuild;
                        } finally {
                        }
                    }
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                        return null;
                    }
                } catch (IOException unused2) {
                }
            }
        }
        return null;
    }

    @Override // D1.b
    public final Typeface k(Context context, Resources resources, int i, String str, int i6) {
        Method method = this.f10693o;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (method == null) {
            return super.k(context, resources, i, str, i6);
        }
        Object objU = U();
        if (objU != null) {
            if (!R(context, objU, str, 0, -1, -1, null)) {
                Q(objU);
                return null;
            }
            if (T(objU)) {
                return S(objU);
            }
        }
        return null;
    }
}
