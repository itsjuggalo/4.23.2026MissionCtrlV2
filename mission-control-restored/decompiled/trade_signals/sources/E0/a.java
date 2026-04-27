package E0;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import w.C2882a;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2882a f877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2882a f878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C2882a f879c;

    public a(C2882a c2882a, C2882a c2882a2, C2882a c2882a3) {
        this.f877a = c2882a;
        this.f878b = c2882a2;
        this.f879c = c2882a3;
    }

    public abstract void A(byte[] bArr);

    public void B(byte[] bArr, int i8) {
        w(i8);
        A(bArr);
    }

    public abstract void C(CharSequence charSequence);

    public void D(CharSequence charSequence, int i8) {
        w(i8);
        C(charSequence);
    }

    public abstract void E(int i8);

    public void F(int i8, int i9) {
        w(i9);
        E(i8);
    }

    public abstract void G(Parcelable parcelable);

    public void H(Parcelable parcelable, int i8) {
        w(i8);
        G(parcelable);
    }

    public abstract void I(String str);

    public void J(String str, int i8) {
        w(i8);
        I(str);
    }

    public void K(c cVar, a aVar) {
        try {
            e(cVar.getClass()).invoke(null, cVar, aVar);
        } catch (ClassNotFoundException e8) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e8);
        } catch (IllegalAccessException e9) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e9);
        } catch (NoSuchMethodException e10) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e10);
        } catch (InvocationTargetException e11) {
            if (!(e11.getCause() instanceof RuntimeException)) {
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e11);
            }
            throw ((RuntimeException) e11.getCause());
        }
    }

    public void L(c cVar) {
        if (cVar == null) {
            I(null);
            return;
        }
        N(cVar);
        a aVarB = b();
        K(cVar, aVarB);
        aVarB.a();
    }

    public void M(c cVar, int i8) {
        w(i8);
        L(cVar);
    }

    public final void N(c cVar) {
        try {
            I(c(cVar.getClass()).getName());
        } catch (ClassNotFoundException e8) {
            throw new RuntimeException(cVar.getClass().getSimpleName() + " does not have a Parcelizer", e8);
        }
    }

    public abstract void a();

    public abstract a b();

    public final Class c(Class cls) throws ClassNotFoundException {
        Class cls2 = (Class) this.f879c.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
        this.f879c.put(cls.getName(), cls3);
        return cls3;
    }

    public final Method d(String str) throws NoSuchMethodException {
        Method method = (Method) this.f877a.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, a.class.getClassLoader()).getDeclaredMethod("read", a.class);
        this.f877a.put(str, declaredMethod);
        return declaredMethod;
    }

    public final Method e(Class cls) throws NoSuchMethodException, ClassNotFoundException {
        Method method = (Method) this.f878b.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class clsC = c(cls);
        System.currentTimeMillis();
        Method declaredMethod = clsC.getDeclaredMethod("write", cls, a.class);
        this.f878b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    public boolean f() {
        return false;
    }

    public abstract boolean g();

    public boolean h(boolean z7, int i8) {
        return !m(i8) ? z7 : g();
    }

    public abstract byte[] i();

    public byte[] j(byte[] bArr, int i8) {
        return !m(i8) ? bArr : i();
    }

    public abstract CharSequence k();

    public CharSequence l(CharSequence charSequence, int i8) {
        return !m(i8) ? charSequence : k();
    }

    public abstract boolean m(int i8);

    public c n(String str, a aVar) {
        try {
            return (c) d(str).invoke(null, aVar);
        } catch (ClassNotFoundException e8) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e8);
        } catch (IllegalAccessException e9) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e9);
        } catch (NoSuchMethodException e10) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e10);
        } catch (InvocationTargetException e11) {
            if (e11.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e11.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e11);
        }
    }

    public abstract int o();

    public int p(int i8, int i9) {
        return !m(i9) ? i8 : o();
    }

    public abstract Parcelable q();

    public Parcelable r(Parcelable parcelable, int i8) {
        return !m(i8) ? parcelable : q();
    }

    public abstract String s();

    public String t(String str, int i8) {
        return !m(i8) ? str : s();
    }

    public c u() {
        String strS = s();
        if (strS == null) {
            return null;
        }
        return n(strS, b());
    }

    public c v(c cVar, int i8) {
        return !m(i8) ? cVar : u();
    }

    public abstract void w(int i8);

    public abstract void y(boolean z7);

    public void z(boolean z7, int i8) {
        w(i8);
        y(z7);
    }

    public void x(boolean z7, boolean z8) {
    }
}
