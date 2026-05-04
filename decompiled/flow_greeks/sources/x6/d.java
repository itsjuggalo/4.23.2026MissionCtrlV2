package x6;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import x6.e;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f24238b = new d(new e.a());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f24239c = new d(new e.C0427e());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f24240d = new d(new e.g());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f24241e = new d(new e.f());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f24242f = new d(new e.b());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f24243g = new d(new e.d());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d f24244h = new d(new e.c());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f24245a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final x6.e f24246a;

        @Override // x6.d.e
        public Object a(String str) {
            Iterator it = d.b("GmsCore_OpenSSL", "AndroidOpenSSL").iterator();
            Exception exc = null;
            while (it.hasNext()) {
                try {
                    return this.f24246a.a(str, (Provider) it.next());
                } catch (Exception e10) {
                    if (exc == null) {
                        exc = e10;
                    }
                }
            }
            return this.f24246a.a(str, null);
        }

        public b(x6.e eVar) {
            this.f24246a = eVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final x6.e f24247a;

        @Override // x6.d.e
        public Object a(String str) {
            return this.f24247a.a(str, null);
        }

        public c(x6.e eVar) {
            this.f24247a = eVar;
        }
    }

    /* JADX INFO: renamed from: x6.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class C0426d implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final x6.e f24248a;

        @Override // x6.d.e
        public Object a(String str) throws GeneralSecurityException {
            Iterator it = d.b("GmsCore_OpenSSL", "AndroidOpenSSL", "Conscrypt").iterator();
            Exception exc = null;
            while (it.hasNext()) {
                try {
                    return this.f24248a.a(str, (Provider) it.next());
                } catch (Exception e10) {
                    if (exc == null) {
                        exc = e10;
                    }
                }
            }
            throw new GeneralSecurityException("No good Provider found.", exc);
        }

        public C0426d(x6.e eVar) {
            this.f24248a = eVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface e {
        Object a(String str);
    }

    public d(x6.e eVar) {
        if (w6.b.c()) {
            this.f24245a = new C0426d(eVar);
        } else if (h.a()) {
            this.f24245a = new b(eVar);
        } else {
            this.f24245a = new c(eVar);
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
        return this.f24245a.a(str);
    }
}
