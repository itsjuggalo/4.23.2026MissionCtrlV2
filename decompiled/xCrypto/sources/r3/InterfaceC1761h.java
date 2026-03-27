package r3;

import java.util.List;

/* JADX INFO: renamed from: r3.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC1761h {

    /* JADX INFO: renamed from: r3.h$a */
    public static final class a {
        public static b a(InterfaceC1761h interfaceC1761h) {
            return new b(interfaceC1761h);
        }
    }

    /* JADX INFO: renamed from: r3.h$b */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC1761h f14587a;

        public b(InterfaceC1761h match) {
            kotlin.jvm.internal.r.f(match, "match");
            this.f14587a = match;
        }

        public final InterfaceC1761h a() {
            return this.f14587a;
        }
    }

    b a();

    List b();
}
