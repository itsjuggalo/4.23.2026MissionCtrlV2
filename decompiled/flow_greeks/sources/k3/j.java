package k3;

import c4.k;
import c4.l;
import d4.a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c4.h f14519a = new c4.h(1000);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s0.c f14520b = d4.a.d(10, new a());

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements a.d {
        public a() {
        }

        @Override // d4.a.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a() {
            try {
                return new b(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements a.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MessageDigest f14522a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d4.c f14523b = d4.c.a();

        public b(MessageDigest messageDigest) {
            this.f14522a = messageDigest;
        }

        @Override // d4.a.f
        public d4.c i() {
            return this.f14523b;
        }
    }

    public final String a(g3.f fVar) {
        b bVar = (b) k.e((b) this.f14520b.b());
        try {
            fVar.b(bVar.f14522a);
            return l.x(bVar.f14522a.digest());
        } finally {
            this.f14520b.a(bVar);
        }
    }

    public String b(g3.f fVar) {
        String strA;
        synchronized (this.f14519a) {
            strA = (String) this.f14519a.g(fVar);
        }
        if (strA == null) {
            strA = a(fVar);
        }
        synchronized (this.f14519a) {
            this.f14519a.k(fVar, strA);
        }
        return strA;
    }
}
