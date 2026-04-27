package K0;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import u.C2736a;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2736a f3338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2736a f3339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C2736a f3340c;

    public a(C2736a c2736a, C2736a c2736a2, C2736a c2736a3) {
        this.f3338a = c2736a;
        this.f3339b = c2736a2;
        this.f3340c = c2736a3;
    }

    public abstract void A(byte[] bArr);

    public void B(byte[] bArr, int i7) {
        w(i7);
        A(bArr);
    }

    public abstract void C(CharSequence charSequence);

    public void D(CharSequence charSequence, int i7) {
        w(i7);
        C(charSequence);
    }

    public abstract void E(int i7);

    public void F(int i7, int i8) {
        w(i8);
        E(i7);
    }

    public abstract void G(Parcelable parcelable);

    public void H(Parcelable parcelable, int i7) {
        w(i7);
        G(parcelable);
    }

    public abstract void I(String str);

    public void J(String str, int i7) {
        w(i7);
        I(str);
    }

    public void K(c cVar, a aVar) {
        try {
            e(cVar.getClass()).invoke(null, cVar, aVar);
        } catch (ClassNotFoundException e7) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e7);
        } catch (IllegalAccessException e8) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e8);
        } catch (NoSuchMethodException e9) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e9);
        } catch (InvocationTargetException e10) {
            if (!(e10.getCause() instanceof RuntimeException)) {
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e10);
            }
            throw ((RuntimeException) e10.getCause());
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

    public void M(c cVar, int i7) {
        w(i7);
        L(cVar);
    }

    public final void N(c cVar) {
        try {
            I(c(cVar.getClass()).getName());
        } catch (ClassNotFoundException e7) {
            throw new RuntimeException(cVar.getClass().getSimpleName() + " does not have a Parcelizer", e7);
        }
    }

    public abstract void a();

    public abstract a b();

    public final Class c(Class cls) throws ClassNotFoundException {
        Class cls2 = (Class) this.f3340c.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
        this.f3340c.put(cls.getName(), cls3);
        return cls3;
    }

    public final Method d(String str) throws NoSuchMethodException {
        Method method = (Method) this.f3338a.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, a.class.getClassLoader()).getDeclaredMethod("read", a.class);
        this.f3338a.put(str, declaredMethod);
        return declaredMethod;
    }

    public final Method e(Class cls) throws NoSuchMethodException, ClassNotFoundException {
        Method method = (Method) this.f3339b.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class clsC = c(cls);
        System.currentTimeMillis();
        Method declaredMethod = clsC.getDeclaredMethod("write", cls, a.class);
        this.f3339b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    public boolean f() {
        return false;
    }

    public abstract boolean g();

    public boolean h(boolean z7, int i7) {
        return !m(i7) ? z7 : g();
    }

    public abstract byte[] i();

    public byte[] j(byte[] bArr, int i7) {
        return !m(i7) ? bArr : i();
    }

    public abstract CharSequence k();

    public CharSequence l(CharSequence charSequence, int i7) {
        return !m(i7) ? charSequence : k();
    }

    public abstract boolean m(int i7);

    public c n(String str, a aVar) {
        try {
            return (c) d(str).invoke(null, aVar);
        } catch (ClassNotFoundException e7) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e7);
        } catch (IllegalAccessException e8) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e8);
        } catch (NoSuchMethodException e9) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e9);
        } catch (InvocationTargetException e10) {
            if (e10.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e10.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e10);
        }
    }

    public abstract int o();

    public int p(int i7, int i8) {
        return !m(i8) ? i7 : o();
    }

    public abstract Parcelable q();

    public Parcelable r(Parcelable parcelable, int i7) {
        return !m(i7) ? parcelable : q();
    }

    public abstract String s();

    public String t(String str, int i7) {
        return !m(i7) ? str : s();
    }

    public c u() {
        String strS = s();
        if (strS == null) {
            return null;
        }
        return n(strS, b());
    }

    public c v(c cVar, int i7) {
        return !m(i7) ? cVar : u();
    }

    public abstract void w(int i7);

    public abstract void y(boolean z7);

    public void z(boolean z7, int i7) {
        w(i7);
        y(z7);
    }

    public void x(boolean z7, boolean z8) {
    }
}
