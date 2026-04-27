package f0;

import androidx.datastore.preferences.protobuf.C0950v;
import c0.C1114c;
import java.io.InputStream;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: f0.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1545d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14034a = new a(null);

    /* JADX INFO: renamed from: f0.d$a */
    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public final C1547f a(InputStream input) throws C1114c {
            r.f(input, "input");
            try {
                C1547f c1547fV = C1547f.V(input);
                r.e(c1547fV, "{\n                Prefer…From(input)\n            }");
                return c1547fV;
            } catch (C0950v e7) {
                throw new C1114c("Unable to parse preferences proto.", e7);
            }
        }

        public a() {
        }
    }
}
