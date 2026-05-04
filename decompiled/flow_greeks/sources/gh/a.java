package gh;

import java.util.List;
import kotlin.jvm.internal.t;
import pd.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: gh.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0195a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final zg.b f10768a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0195a(zg.b serializer) {
            super(null);
            t.f(serializer, "serializer");
            this.f10768a = serializer;
        }

        @Override // gh.a
        public zg.b a(List typeArgumentsSerializers) {
            t.f(typeArgumentsSerializers, "typeArgumentsSerializers");
            return this.f10768a;
        }

        public final zg.b b() {
            return this.f10768a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof C0195a) && t.b(((C0195a) obj).f10768a, this.f10768a);
        }

        public int hashCode() {
            return this.f10768a.hashCode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k f10769a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(k provider) {
            super(null);
            t.f(provider, "provider");
            this.f10769a = provider;
        }

        @Override // gh.a
        public zg.b a(List typeArgumentsSerializers) {
            t.f(typeArgumentsSerializers, "typeArgumentsSerializers");
            return (zg.b) this.f10769a.invoke(typeArgumentsSerializers);
        }

        public final k b() {
            return this.f10769a;
        }
    }

    public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
        this();
    }

    public abstract zg.b a(List list);

    public a() {
    }
}
