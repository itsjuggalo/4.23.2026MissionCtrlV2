package h3;

import java.util.ArrayList;
import p3.C2548b;
import p3.InterfaceC2560n;

/* JADX INFO: renamed from: h3.E, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1861E {

    /* JADX INFO: renamed from: h3.E$a */
    public static class a extends AbstractC1861E {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final x f18400a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C1875k f18401b;

        public a(x xVar, C1875k c1875k) {
            this.f18400a = xVar;
            this.f18401b = c1875k;
        }

        @Override // h3.AbstractC1861E
        public AbstractC1861E a(C2548b c2548b) {
            return new a(this.f18400a, this.f18401b.K(c2548b));
        }

        @Override // h3.AbstractC1861E
        public InterfaceC2560n b() {
            return this.f18400a.J(this.f18401b, new ArrayList());
        }
    }

    /* JADX INFO: renamed from: h3.E$b */
    public static class b extends AbstractC1861E {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC2560n f18402a;

        public b(InterfaceC2560n interfaceC2560n) {
            this.f18402a = interfaceC2560n;
        }

        @Override // h3.AbstractC1861E
        public AbstractC1861E a(C2548b c2548b) {
            return new b(this.f18402a.z(c2548b));
        }

        @Override // h3.AbstractC1861E
        public InterfaceC2560n b() {
            return this.f18402a;
        }
    }

    public abstract AbstractC1861E a(C2548b c2548b);

    public abstract InterfaceC2560n b();
}
