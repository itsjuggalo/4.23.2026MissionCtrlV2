package a1;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11a = new a(null);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(k kVar) {
            this();
        }

        public final Object b(z0.e eVar, String str, Object obj) throws b1.b {
            if (obj instanceof a1.a) {
                return new a1.a(eVar, str);
            }
            if (obj instanceof d) {
                return new d(eVar, str);
            }
            throw new b1.b();
        }

        public a() {
        }
    }
}
