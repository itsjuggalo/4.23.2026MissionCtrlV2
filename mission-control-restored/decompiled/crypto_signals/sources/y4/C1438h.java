package y4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.Provider;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.net.ssl.SSLSocket;

/* JADX INFO: renamed from: y4.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1438h extends C1440j {
    public final Method e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Method f11697f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Method f11698g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Class f11699h;
    public final Class i;

    public C1438h(Method method, Method method2, Method method3, Class cls, Class cls2, Provider provider) {
        super(provider);
        this.e = method;
        this.f11697f = method2;
        this.f11698g = method3;
        this.f11699h = cls;
        this.i = cls2;
    }

    @Override // y4.C1440j
    public final void a(SSLSocket sSLSocket) {
        try {
            this.f11698g.invoke(null, sSLSocket);
        } catch (IllegalAccessException unused) {
            throw new AssertionError();
        } catch (InvocationTargetException e) {
            C1440j.f11703b.log(Level.FINE, "Failed to remove SSLSocket from Jetty ALPN", (Throwable) e);
        }
    }

    @Override // y4.C1440j
    public final void c(SSLSocket sSLSocket, String str, List list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            EnumC1441k enumC1441k = (EnumC1441k) list.get(i);
            if (enumC1441k != EnumC1441k.HTTP_1_0) {
                arrayList.add(enumC1441k.f11711a);
            }
        }
        try {
            this.e.invoke(null, sSLSocket, Proxy.newProxyInstance(C1440j.class.getClassLoader(), new Class[]{this.f11699h, this.i}, new C1439i(arrayList)));
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // y4.C1440j
    public final String d(SSLSocket sSLSocket) {
        try {
            C1439i c1439i = (C1439i) Proxy.getInvocationHandler(this.f11697f.invoke(null, sSLSocket));
            boolean z6 = c1439i.f11701b;
            if (!z6 && c1439i.f11702c == null) {
                C1440j.f11703b.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
                return null;
            }
            if (z6) {
                return null;
            }
            return c1439i.f11702c;
        } catch (IllegalAccessException unused) {
            throw new AssertionError();
        } catch (InvocationTargetException unused2) {
            throw new AssertionError();
        }
    }

    @Override // y4.C1440j
    public final int e() {
        return 1;
    }
}
