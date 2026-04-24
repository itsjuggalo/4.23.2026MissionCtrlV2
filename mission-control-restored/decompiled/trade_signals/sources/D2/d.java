package D2;

import D2.e;
import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f766b = new d(new e.a());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f767c = new d(new e.C0016e());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f768d = new d(new e.g());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f769e = new d(new e.f());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f770f = new d(new e.b());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f771g = new d(new e.d());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d f772h = new d(new e.c());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f773a;

    public static class b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final D2.e f774a;

        public b(D2.e eVar) {
            this.f774a = eVar;
        }

        @Override // D2.d.e
        public Object a(String str) {
            Iterator it = d.b("GmsCore_OpenSSL", "AndroidOpenSSL").iterator();
            Exception exc = null;
            while (it.hasNext()) {
                try {
                    return this.f774a.a(str, (Provider) it.next());
                } catch (Exception e8) {
                    if (exc == null) {
                        exc = e8;
                    }
                }
            }
            return this.f774a.a(str, null);
        }
    }

    public static class c implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final D2.e f775a;

        public c(D2.e eVar) {
            this.f775a = eVar;
        }

        @Override // D2.d.e
        public Object a(String str) {
            return this.f775a.a(str, null);
        }
    }

    /* JADX INFO: renamed from: D2.d$d, reason: collision with other inner class name */
    public static class C0015d implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final D2.e f776a;

        public C0015d(D2.e eVar) {
            this.f776a = eVar;
        }

        @Override // D2.d.e
        public Object a(String str) throws GeneralSecurityException {
            Iterator it = d.b("GmsCore_OpenSSL", "AndroidOpenSSL", "Conscrypt").iterator();
            Exception exc = null;
            while (it.hasNext()) {
                try {
                    return this.f776a.a(str, (Provider) it.next());
                } catch (Exception e8) {
                    if (exc == null) {
                        exc = e8;
                    }
                }
            }
            throw new GeneralSecurityException("No good Provider found.", exc);
        }
    }

    public interface e {
        Object a(String str);
    }

    public d(D2.e eVar) {
        this.f773a = C2.b.c() ? new C0015d(eVar) : h.a() ? new b(eVar) : new c(eVar);
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
        return this.f773a.a(str);
    }
}
