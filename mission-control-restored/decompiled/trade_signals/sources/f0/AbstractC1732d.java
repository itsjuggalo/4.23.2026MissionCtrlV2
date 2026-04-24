package f0;

import androidx.datastore.preferences.protobuf.C1119v;
import b0.C1173d;
import java.io.InputStream;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: f0.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1732d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f17355a = new a(null);

    /* JADX INFO: renamed from: f0.d$a */
    public static final class a {
        public a() {
        }

        public final f a(InputStream input) throws C1173d {
            AbstractC2304t.f(input, "input");
            try {
                f fVarV = f.V(input);
                AbstractC2304t.e(fVarV, "{\n                Prefer…From(input)\n            }");
                return fVarV;
            } catch (C1119v e8) {
                throw new C1173d("Unable to parse preferences proto.", e8);
            }
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }
}
