package J3;

import J3.C;

/* JADX INFO: loaded from: classes3.dex */
public abstract class E {

    public static final class a implements C {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ F3.b f870a;

        public a(F3.b bVar) {
            this.f870a = bVar;
        }

        @Override // J3.C
        public F3.b[] childSerializers() {
            return new F3.b[]{this.f870a};
        }

        @Override // F3.a
        public Object deserialize(I3.e decoder) {
            kotlin.jvm.internal.r.f(decoder, "decoder");
            throw new IllegalStateException("unsupported");
        }

        @Override // F3.b, F3.h, F3.a
        public H3.e getDescriptor() {
            throw new IllegalStateException("unsupported");
        }

        @Override // F3.h
        public void serialize(I3.f encoder, Object obj) {
            kotlin.jvm.internal.r.f(encoder, "encoder");
            throw new IllegalStateException("unsupported");
        }

        @Override // J3.C
        public F3.b[] typeParametersSerializers() {
            return C.a.a(this);
        }
    }

    public static final H3.e a(String name, F3.b primitiveSerializer) {
        kotlin.jvm.internal.r.f(name, "name");
        kotlin.jvm.internal.r.f(primitiveSerializer, "primitiveSerializer");
        return new D(name, new a(primitiveSerializer));
    }
}
