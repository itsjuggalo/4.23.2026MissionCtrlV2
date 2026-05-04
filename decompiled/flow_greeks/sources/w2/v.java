package w2;

import android.app.Activity;
import w2.v;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public interface v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f23663a = a.f23664a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f23664a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static pd.k f23665b = new pd.k() { // from class: w2.u
            @Override // pd.k
            public final Object invoke(Object obj) {
                return v.a.b((v) obj);
            }
        };

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final w f23666c = new w(null, 1, 0 == true ? 1 : 0);

        public static final v b(v it) {
            kotlin.jvm.internal.t.f(it, "it");
            return it;
        }

        public final v c() {
            return (v) f23665b.invoke(f23666c);
        }
    }

    static v b() {
        return f23663a.c();
    }

    t a(Activity activity);
}
