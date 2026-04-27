package u6;

import Q5.k;
import java.util.List;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: u6.a$a, reason: collision with other inner class name */
    public static final class C0381a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final n6.b f24689a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0381a(n6.b serializer) {
            super(null);
            r.f(serializer, "serializer");
            this.f24689a = serializer;
        }

        @Override // u6.a
        public n6.b a(List typeArgumentsSerializers) {
            r.f(typeArgumentsSerializers, "typeArgumentsSerializers");
            return this.f24689a;
        }

        public final n6.b b() {
            return this.f24689a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof C0381a) && r.b(((C0381a) obj).f24689a, this.f24689a);
        }

        public int hashCode() {
            return this.f24689a.hashCode();
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k f24690a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(k provider) {
            super(null);
            r.f(provider, "provider");
            this.f24690a = provider;
        }

        @Override // u6.a
        public n6.b a(List typeArgumentsSerializers) {
            r.f(typeArgumentsSerializers, "typeArgumentsSerializers");
            return (n6.b) this.f24690a.invoke(typeArgumentsSerializers);
        }

        public final k b() {
            return this.f24690a;
        }
    }

    public /* synthetic */ a(AbstractC2148j abstractC2148j) {
        this();
    }

    public abstract n6.b a(List list);

    public a() {
    }
}
