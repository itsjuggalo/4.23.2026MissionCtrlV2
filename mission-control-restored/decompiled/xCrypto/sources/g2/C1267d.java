package g2;

import f2.AbstractC1246b;
import g2.InterfaceC1268e;
import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: g2.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1267d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C1267d f11948b = new C1267d(new InterfaceC1268e.a());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C1267d f11949c = new C1267d(new InterfaceC1268e.C0199e());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C1267d f11950d = new C1267d(new InterfaceC1268e.g());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C1267d f11951e = new C1267d(new InterfaceC1268e.f());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C1267d f11952f = new C1267d(new InterfaceC1268e.b());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C1267d f11953g = new C1267d(new InterfaceC1268e.d());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C1267d f11954h = new C1267d(new InterfaceC1268e.c());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f11955a;

    /* JADX INFO: renamed from: g2.d$b */
    public static class b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC1268e f11956a;

        @Override // g2.C1267d.e
        public Object a(String str) {
            Iterator it = C1267d.b("GmsCore_OpenSSL", "AndroidOpenSSL").iterator();
            Exception exc = null;
            while (it.hasNext()) {
                try {
                    return this.f11956a.a(str, (Provider) it.next());
                } catch (Exception e4) {
                    if (exc == null) {
                        exc = e4;
                    }
                }
            }
            return this.f11956a.a(str, null);
        }

        public b(InterfaceC1268e interfaceC1268e) {
            this.f11956a = interfaceC1268e;
        }
    }

    /* JADX INFO: renamed from: g2.d$c */
    public static class c implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC1268e f11957a;

        @Override // g2.C1267d.e
        public Object a(String str) {
            return this.f11957a.a(str, null);
        }

        public c(InterfaceC1268e interfaceC1268e) {
            this.f11957a = interfaceC1268e;
        }
    }

    /* JADX INFO: renamed from: g2.d$d, reason: collision with other inner class name */
    public static class C0198d implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC1268e f11958a;

        @Override // g2.C1267d.e
        public Object a(String str) throws GeneralSecurityException {
            Iterator it = C1267d.b("GmsCore_OpenSSL", "AndroidOpenSSL", "Conscrypt").iterator();
            Exception exc = null;
            while (it.hasNext()) {
                try {
                    return this.f11958a.a(str, (Provider) it.next());
                } catch (Exception e4) {
                    if (exc == null) {
                        exc = e4;
                    }
                }
            }
            throw new GeneralSecurityException("No good Provider found.", exc);
        }

        public C0198d(InterfaceC1268e interfaceC1268e) {
            this.f11958a = interfaceC1268e;
        }
    }

    /* JADX INFO: renamed from: g2.d$e */
    public interface e {
        Object a(String str);
    }

    public C1267d(InterfaceC1268e interfaceC1268e) {
        if (AbstractC1246b.c()) {
            this.f11955a = new C0198d(interfaceC1268e);
        } else if (h.a()) {
            this.f11955a = new b(interfaceC1268e);
        } else {
            this.f11955a = new c(interfaceC1268e);
        }
    }

    public static List b(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Provider provider = Security.getProvider(str);
            if (provider != null) {
                arrayList.add(provider);
            }
        }
        return arrayList;
    }

    public Object a(String str) {
        return this.f11955a.a(str);
    }
}
