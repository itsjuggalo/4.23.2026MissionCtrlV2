package Z5;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface g {

    public static final class a {
        public static b a(g gVar) {
            return new b(gVar);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g f6036a;

        public b(g match) {
            kotlin.jvm.internal.r.f(match, "match");
            this.f6036a = match;
        }

        public final g a() {
            return this.f6036a;
        }
    }

    b a();

    List b();
}
