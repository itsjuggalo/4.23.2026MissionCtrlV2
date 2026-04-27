package O2;

import O2.e;
import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f4139b = new d(new e.a());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f4140c = new d(new e.C0065e());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f4141d = new d(new e.g());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f4142e = new d(new e.f());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f4143f = new d(new e.b());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f4144g = new d(new e.d());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d f4145h = new d(new e.c());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f4146a;

    public static class b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final O2.e f4147a;

        @Override // O2.d.e
        public Object a(String str) {
            Iterator it = d.b("GmsCore_OpenSSL", "AndroidOpenSSL").iterator();
            Exception exc = null;
            while (it.hasNext()) {
                try {
                    return this.f4147a.a(str, (Provider) it.next());
                } catch (Exception e7) {
                    if (exc == null) {
                        exc = e7;
                    }
                }
            }
            return this.f4147a.a(str, null);
        }

        public b(O2.e eVar) {
            this.f4147a = eVar;
        }
    }

    public static class c implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final O2.e f4148a;

        @Override // O2.d.e
        public Object a(String str) {
            return this.f4148a.a(str, null);
        }

        public c(O2.e eVar) {
            this.f4148a = eVar;
        }
    }

    /* JADX INFO: renamed from: O2.d$d, reason: collision with other inner class name */
    public static class C0064d implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final O2.e f4149a;

        @Override // O2.d.e
        public Object a(String str) throws GeneralSecurityException {
            Iterator it = d.b("GmsCore_OpenSSL", "AndroidOpenSSL", "Conscrypt").iterator();
            Exception exc = null;
            while (it.hasNext()) {
                try {
                    return this.f4149a.a(str, (Provider) it.next());
                } catch (Exception e7) {
                    if (exc == null) {
                        exc = e7;
                    }
                }
            }
            throw new GeneralSecurityException("No good Provider found.", exc);
        }

        public C0064d(O2.e eVar) {
            this.f4149a = eVar;
        }
    }

    public interface e {
        Object a(String str);
    }

    public d(O2.e eVar) {
        if (N2.b.c()) {
            this.f4146a = new C0064d(eVar);
        } else if (h.a()) {
            this.f4146a = new b(eVar);
        } else {
            this.f4146a = new c(eVar);
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
        return this.f4146a.a(str);
    }
}
