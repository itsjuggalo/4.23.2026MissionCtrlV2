package Y0;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import q1.AbstractC2628k;
import q1.AbstractC2629l;
import q1.C2625h;
import r1.AbstractC2670a;
import r1.AbstractC2672c;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2625h f9523a = new C2625h(1000);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final S.d f9524b = AbstractC2670a.d(10, new a());

    public class a implements AbstractC2670a.d {
        public a() {
        }

        @Override // r1.AbstractC2670a.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a() {
            try {
                return new b(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e8) {
                throw new RuntimeException(e8);
            }
        }
    }

    public static final class b implements AbstractC2670a.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MessageDigest f9526a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AbstractC2672c f9527b = AbstractC2672c.a();

        public b(MessageDigest messageDigest) {
            this.f9526a = messageDigest;
        }

        @Override // r1.AbstractC2670a.f
        public AbstractC2672c a() {
            return this.f9527b;
        }
    }

    public final String a(U0.f fVar) {
        b bVar = (b) AbstractC2628k.d(this.f9524b.b());
        try {
            fVar.a(bVar.f9526a);
            return AbstractC2629l.w(bVar.f9526a.digest());
        } finally {
            this.f9524b.a(bVar);
        }
    }

    public String b(U0.f fVar) {
        String strA;
        synchronized (this.f9523a) {
            strA = (String) this.f9523a.g(fVar);
        }
        if (strA == null) {
            strA = a(fVar);
        }
        synchronized (this.f9523a) {
            this.f9523a.k(fVar, strA);
        }
        return strA;
    }
}
