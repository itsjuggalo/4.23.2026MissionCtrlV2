package lf;

import fe.h0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class l extends g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f15659b = new a(null);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final l a(String message) {
            kotlin.jvm.internal.t.f(message, "message");
            return new b(message);
        }

        public a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends l {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f15660c;

        public b(String message) {
            kotlin.jvm.internal.t.f(message, "message");
            this.f15660c = message;
        }

        @Override // lf.g
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public zf.i a(h0 module) {
            kotlin.jvm.internal.t.f(module, "module");
            return zf.l.d(zf.k.f26531q0, this.f15660c);
        }

        @Override // lf.g
        public String toString() {
            return this.f15660c;
        }
    }

    public l() {
        super(cd.h0.f3852a);
    }

    @Override // lf.g
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public cd.h0 b() {
        throw new UnsupportedOperationException();
    }
}
