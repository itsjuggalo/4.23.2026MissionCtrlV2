package M3;

import i3.k;
import java.util.List;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: M3.a$a, reason: collision with other inner class name */
    public static final class C0047a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final F3.b f2681a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0047a(F3.b serializer) {
            super(null);
            r.f(serializer, "serializer");
            this.f2681a = serializer;
        }

        @Override // M3.a
        public F3.b a(List typeArgumentsSerializers) {
            r.f(typeArgumentsSerializers, "typeArgumentsSerializers");
            return this.f2681a;
        }

        public final F3.b b() {
            return this.f2681a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof C0047a) && r.b(((C0047a) obj).f2681a, this.f2681a);
        }

        public int hashCode() {
            return this.f2681a.hashCode();
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k f2682a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(k provider) {
            super(null);
            r.f(provider, "provider");
            this.f2682a = provider;
        }

        @Override // M3.a
        public F3.b a(List typeArgumentsSerializers) {
            r.f(typeArgumentsSerializers, "typeArgumentsSerializers");
            return (F3.b) this.f2682a.invoke(typeArgumentsSerializers);
        }

        public final k b() {
            return this.f2682a;
        }
    }

    public /* synthetic */ a(AbstractC1585j abstractC1585j) {
        this();
    }

    public abstract F3.b a(List list);

    public a() {
    }
}
