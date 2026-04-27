package o7;

import kotlin.jvm.internal.AbstractC2304t;
import o7.E;

/* JADX INFO: loaded from: classes2.dex */
public abstract class G {

    public static final class a implements E {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k7.b f22109a;

        public a(k7.b bVar) {
            this.f22109a = bVar;
        }

        @Override // o7.E
        public k7.b[] childSerializers() {
            return new k7.b[]{this.f22109a};
        }

        @Override // k7.a
        public Object deserialize(n7.e decoder) {
            AbstractC2304t.f(decoder, "decoder");
            throw new IllegalStateException("unsupported".toString());
        }

        @Override // k7.b, k7.k, k7.a
        public m7.e getDescriptor() {
            throw new IllegalStateException("unsupported".toString());
        }

        @Override // k7.k
        public void serialize(n7.f encoder, Object obj) {
            AbstractC2304t.f(encoder, "encoder");
            throw new IllegalStateException("unsupported".toString());
        }

        @Override // o7.E
        public k7.b[] typeParametersSerializers() {
            return E.a.a(this);
        }
    }

    public static final m7.e a(String name, k7.b primitiveSerializer) {
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(primitiveSerializer, "primitiveSerializer");
        return new F(name, new a(primitiveSerializer));
    }
}
