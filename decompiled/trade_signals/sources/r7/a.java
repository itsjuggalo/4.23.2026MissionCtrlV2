package r7;

import B5.k;
import java.util.List;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: r7.a$a, reason: collision with other inner class name */
    public static final class C0393a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k7.b f22920a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0393a(k7.b serializer) {
            super(null);
            AbstractC2304t.f(serializer, "serializer");
            this.f22920a = serializer;
        }

        @Override // r7.a
        public k7.b a(List typeArgumentsSerializers) {
            AbstractC2304t.f(typeArgumentsSerializers, "typeArgumentsSerializers");
            return this.f22920a;
        }

        public final k7.b b() {
            return this.f22920a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof C0393a) && AbstractC2304t.b(((C0393a) obj).f22920a, this.f22920a);
        }

        public int hashCode() {
            return this.f22920a.hashCode();
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k f22921a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(k provider) {
            super(null);
            AbstractC2304t.f(provider, "provider");
            this.f22921a = provider;
        }

        @Override // r7.a
        public k7.b a(List typeArgumentsSerializers) {
            AbstractC2304t.f(typeArgumentsSerializers, "typeArgumentsSerializers");
            return (k7.b) this.f22921a.invoke(typeArgumentsSerializers);
        }

        public final k b() {
            return this.f22921a;
        }
    }

    public a() {
    }

    public abstract k7.b a(List list);

    public /* synthetic */ a(AbstractC2296k abstractC2296k) {
        this();
    }
}
