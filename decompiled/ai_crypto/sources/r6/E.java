package r6;

import r6.C;

/* JADX INFO: loaded from: classes2.dex */
public abstract class E {

    public static final class a implements C {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n6.b f22827a;

        public a(n6.b bVar) {
            this.f22827a = bVar;
        }

        @Override // r6.C
        public n6.b[] childSerializers() {
            return new n6.b[]{this.f22827a};
        }

        @Override // n6.a
        public Object deserialize(q6.e decoder) {
            kotlin.jvm.internal.r.f(decoder, "decoder");
            throw new IllegalStateException("unsupported");
        }

        @Override // n6.b, n6.h, n6.a
        public p6.e getDescriptor() {
            throw new IllegalStateException("unsupported");
        }

        @Override // n6.h
        public void serialize(q6.f encoder, Object obj) {
            kotlin.jvm.internal.r.f(encoder, "encoder");
            throw new IllegalStateException("unsupported");
        }

        @Override // r6.C
        public n6.b[] typeParametersSerializers() {
            return C.a.a(this);
        }
    }

    public static final p6.e a(String name, n6.b primitiveSerializer) {
        kotlin.jvm.internal.r.f(name, "name");
        kotlin.jvm.internal.r.f(primitiveSerializer, "primitiveSerializer");
        return new D(name, new a(primitiveSerializer));
    }
}
