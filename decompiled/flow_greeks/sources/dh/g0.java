package dh;

import dh.e0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g0 {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ zg.b f8145a;

        public a(zg.b bVar) {
            this.f8145a = bVar;
        }

        @Override // dh.e0
        public zg.b[] childSerializers() {
            return new zg.b[]{this.f8145a};
        }

        @Override // zg.a
        public Object deserialize(ch.e decoder) {
            kotlin.jvm.internal.t.f(decoder, "decoder");
            throw new IllegalStateException("unsupported");
        }

        @Override // zg.b, zg.k, zg.a
        public bh.e getDescriptor() {
            throw new IllegalStateException("unsupported");
        }

        @Override // zg.k
        public void serialize(ch.f encoder, Object obj) {
            kotlin.jvm.internal.t.f(encoder, "encoder");
            throw new IllegalStateException("unsupported");
        }

        @Override // dh.e0
        public zg.b[] typeParametersSerializers() {
            return e0.a.a(this);
        }
    }

    public static final bh.e a(String name, zg.b primitiveSerializer) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(primitiveSerializer, "primitiveSerializer");
        return new f0(name, new a(primitiveSerializer));
    }
}
