package U;

import S.C0518d;
import androidx.datastore.preferences.protobuf.C0808v;
import java.io.InputStream;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5234a = new a(null);

    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public final f a(InputStream input) throws C0518d {
            r.f(input, "input");
            try {
                f fVarR = f.R(input);
                r.e(fVarR, "{\n                Prefer…From(input)\n            }");
                return fVarR;
            } catch (C0808v e4) {
                throw new C0518d("Unable to parse preferences proto.", e4);
            }
        }

        public a() {
        }
    }
}
