package y4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.Provider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* JADX INFO: renamed from: y4.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1437g extends C1440j {
    public final Method e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Method f11696f;

    public C1437g(Provider provider, Method method, Method method2) {
        super(provider);
        this.e = method;
        this.f11696f = method2;
    }

    @Override // y4.C1440j
    public final void c(SSLSocket sSLSocket, String str, List list) {
        SSLParameters sSLParameters = sSLSocket.getSSLParameters();
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            EnumC1441k enumC1441k = (EnumC1441k) it.next();
            if (enumC1441k != EnumC1441k.HTTP_1_0) {
                arrayList.add(enumC1441k.f11711a);
            }
        }
        try {
            this.e.invoke(sSLParameters, arrayList.toArray(new String[arrayList.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // y4.C1440j
    public final String d(SSLSocket sSLSocket) {
        try {
            return (String) this.f11696f.invoke(sSLSocket, new Object[0]);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // y4.C1440j
    public final int e() {
        return 1;
    }
}
