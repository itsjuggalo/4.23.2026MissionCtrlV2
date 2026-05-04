package o1;

import androidx.datastore.preferences.protobuf.v;
import java.io.InputStream;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f17447a = new a(null);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(k kVar) {
            this();
        }

        public final f a(InputStream input) throws l1.d {
            t.f(input, "input");
            try {
                f fVarV = f.V(input);
                t.e(fVarV, "{\n                Prefer…From(input)\n            }");
                return fVarV;
            } catch (v e10) {
                throw new l1.d("Unable to parse preferences proto.", e10);
            }
        }

        public a() {
        }
    }
}
