package t0;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import u.C1853a;

/* JADX INFO: renamed from: t0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1782a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1853a f14716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1853a f14717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C1853a f14718c;

    public AbstractC1782a(C1853a c1853a, C1853a c1853a2, C1853a c1853a3) {
        this.f14716a = c1853a;
        this.f14717b = c1853a2;
        this.f14718c = c1853a3;
    }

    public abstract void A(byte[] bArr);

    public void B(byte[] bArr, int i4) {
        w(i4);
        A(bArr);
    }

    public abstract void C(CharSequence charSequence);

    public void D(CharSequence charSequence, int i4) {
        w(i4);
        C(charSequence);
    }

    public abstract void E(int i4);

    public void F(int i4, int i5) {
        w(i5);
        E(i4);
    }

    public abstract void G(Parcelable parcelable);

    public void H(Parcelable parcelable, int i4) {
        w(i4);
        G(parcelable);
    }

    public abstract void I(String str);

    public void J(String str, int i4) {
        w(i4);
        I(str);
    }

    public void K(c cVar, AbstractC1782a abstractC1782a) {
        try {
            e(cVar.getClass()).invoke(null, cVar, abstractC1782a);
        } catch (ClassNotFoundException e4) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e4);
        } catch (IllegalAccessException e5) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e5);
        } catch (NoSuchMethodException e6) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e6);
        } catch (InvocationTargetException e7) {
            if (!(e7.getCause() instanceof RuntimeException)) {
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e7);
            }
            throw ((RuntimeException) e7.getCause());
        }
    }

    public void L(c cVar) {
        if (cVar == null) {
            I(null);
            return;
        }
        N(cVar);
        AbstractC1782a abstractC1782aB = b();
        K(cVar, abstractC1782aB);
        abstractC1782aB.a();
    }

    public void M(c cVar, int i4) {
        w(i4);
        L(cVar);
    }

    public final void N(c cVar) {
        try {
            I(c(cVar.getClass()).getName());
        } catch (ClassNotFoundException e4) {
            throw new RuntimeException(cVar.getClass().getSimpleName() + " does not have a Parcelizer", e4);
        }
    }

    public abstract void a();

    public abstract AbstractC1782a b();

    public final Class c(Class cls) throws ClassNotFoundException {
        Class cls2 = (Class) this.f14718c.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
        this.f14718c.put(cls.getName(), cls3);
        return cls3;
    }

    public final Method d(String str) throws NoSuchMethodException {
        Method method = (Method) this.f14716a.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, AbstractC1782a.class.getClassLoader()).getDeclaredMethod("read", AbstractC1782a.class);
        this.f14716a.put(str, declaredMethod);
        return declaredMethod;
    }

    public final Method e(Class cls) throws NoSuchMethodException, ClassNotFoundException {
        Method method = (Method) this.f14717b.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class clsC = c(cls);
        System.currentTimeMillis();
        Method declaredMethod = clsC.getDeclaredMethod("write", cls, AbstractC1782a.class);
        this.f14717b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    public boolean f() {
        return false;
    }

    public abstract boolean g();

    public boolean h(boolean z4, int i4) {
        return !m(i4) ? z4 : g();
    }

    public abstract byte[] i();

    public byte[] j(byte[] bArr, int i4) {
        return !m(i4) ? bArr : i();
    }

    public abstract CharSequence k();

    public CharSequence l(CharSequence charSequence, int i4) {
        return !m(i4) ? charSequence : k();
    }

    public abstract boolean m(int i4);

    public c n(String str, AbstractC1782a abstractC1782a) {
        try {
            return (c) d(str).invoke(null, abstractC1782a);
        } catch (ClassNotFoundException e4) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e4);
        } catch (IllegalAccessException e5) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e5);
        } catch (NoSuchMethodException e6) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e6);
        } catch (InvocationTargetException e7) {
            if (e7.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e7.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e7);
        }
    }

    public abstract int o();

    public int p(int i4, int i5) {
        return !m(i5) ? i4 : o();
    }

    public abstract Parcelable q();

    public Parcelable r(Parcelable parcelable, int i4) {
        return !m(i4) ? parcelable : q();
    }

    public abstract String s();

    public String t(String str, int i4) {
        return !m(i4) ? str : s();
    }

    public c u() {
        String strS = s();
        if (strS == null) {
            return null;
        }
        return n(strS, b());
    }

    public c v(c cVar, int i4) {
        return !m(i4) ? cVar : u();
    }

    public abstract void w(int i4);

    public abstract void y(boolean z4);

    public void z(boolean z4, int i4) {
        w(i4);
        y(z4);
    }

    public void x(boolean z4, boolean z5) {
    }
}
