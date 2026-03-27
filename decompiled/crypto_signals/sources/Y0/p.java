package Y0;

import android.content.Context;
import d1.InterfaceC0522b;
import h1.InterfaceC0618a;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Set;
import s1.C0994k;

/* JADX INFO: loaded from: classes.dex */
public final class p {
    public static volatile k e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0618a f3580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0618a f3581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC0522b f3582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e1.j f3583d;

    public p(InterfaceC0618a interfaceC0618a, InterfaceC0618a interfaceC0618a2, InterfaceC0522b interfaceC0522b, e1.j jVar, e1.k kVar) {
        this.f3580a = interfaceC0618a;
        this.f3581b = interfaceC0618a2;
        this.f3582c = interfaceC0522b;
        this.f3583d = jVar;
        kVar.getClass();
        kVar.f6075a.execute(new E3.d(kVar, 16));
    }

    public static p a() {
        k kVar = e;
        if (kVar != null) {
            return (p) kVar.f3572f.get();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public static void b(Context context) {
        if (e == null) {
            synchronized (p.class) {
                try {
                    if (e == null) {
                        I0.a aVar = new I0.a();
                        context.getClass();
                        aVar.f623a = context;
                        e = aVar.b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final o c(W0.a aVar) {
        byte[] bytes;
        Set setUnmodifiableSet = aVar != null ? Collections.unmodifiableSet(W0.a.f3327d) : Collections.singleton(new V0.c("proto"));
        C0994k c0994kA = j.a();
        aVar.getClass();
        c0994kA.f9530b = "cct";
        String str = aVar.f3329a;
        String str2 = aVar.f3330b;
        if (str2 == null && str == null) {
            bytes = null;
        } else {
            if (str2 == null) {
                str2 = "";
            }
            bytes = ("1$" + str + "\\" + str2).getBytes(Charset.forName("UTF-8"));
        }
        c0994kA.f9531c = bytes;
        return new o(setUnmodifiableSet, c0994kA.B(), this);
    }
}
