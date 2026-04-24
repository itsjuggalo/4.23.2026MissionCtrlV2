package V6;

import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public interface k {

    public static final class a {
        public static b a(k kVar) {
            return new b(kVar);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k f9010a;

        public b(k match) {
            AbstractC2304t.f(match, "match");
            this.f9010a = match;
        }

        public final k a() {
            return this.f9010a;
        }
    }

    b a();

    List b();
}
