package fh;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a1 {
    public static final Object a(eh.b json, eh.i element, zg.a deserializer) {
        ch.e g0Var;
        kotlin.jvm.internal.t.f(json, "json");
        kotlin.jvm.internal.t.f(element, "element");
        kotlin.jvm.internal.t.f(deserializer, "deserializer");
        if (element instanceof eh.c0) {
            g0Var = new k0(json, (eh.c0) element, null, null, 12, null);
        } else if (element instanceof eh.c) {
            g0Var = new m0(json, (eh.c) element);
        } else {
            if (!(element instanceof eh.v) && !kotlin.jvm.internal.t.b(element, eh.z.INSTANCE)) {
                throw new cd.o();
            }
            g0Var = new g0(json, (eh.e0) element, null, 4, null);
        }
        return g0Var.E(deserializer);
    }

    public static final Object b(eh.b bVar, String discriminator, eh.c0 element, zg.a deserializer) {
        kotlin.jvm.internal.t.f(bVar, "<this>");
        kotlin.jvm.internal.t.f(discriminator, "discriminator");
        kotlin.jvm.internal.t.f(element, "element");
        kotlin.jvm.internal.t.f(deserializer, "deserializer");
        return new k0(bVar, element, discriminator, deserializer.getDescriptor()).E(deserializer);
    }
}
