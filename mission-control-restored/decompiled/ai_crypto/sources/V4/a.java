package V4;

import V4.b;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V4.b f5308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f5310c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b.c f5311d;

    public final class b implements b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f5312a;

        /* JADX INFO: renamed from: V4.a$b$a, reason: collision with other inner class name */
        public class C0091a implements e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b.InterfaceC0092b f5314a;

            public C0091a(b.InterfaceC0092b interfaceC0092b) {
                this.f5314a = interfaceC0092b;
            }

            @Override // V4.a.e
            public void a(Object obj) {
                this.f5314a.a(a.this.f5310c.a(obj));
            }
        }

        @Override // V4.b.a
        public void a(ByteBuffer byteBuffer, b.InterfaceC0092b interfaceC0092b) {
            try {
                this.f5312a.a(a.this.f5310c.b(byteBuffer), new C0091a(interfaceC0092b));
            } catch (RuntimeException e7) {
                J4.b.c("BasicMessageChannel#" + a.this.f5309b, "Failed to handle message", e7);
                interfaceC0092b.a(null);
            }
        }

        public b(d dVar) {
            this.f5312a = dVar;
        }
    }

    public final class c implements b.InterfaceC0092b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f5316a;

        @Override // V4.b.InterfaceC0092b
        public void a(ByteBuffer byteBuffer) {
            try {
                this.f5316a.a(a.this.f5310c.b(byteBuffer));
            } catch (RuntimeException e7) {
                J4.b.c("BasicMessageChannel#" + a.this.f5309b, "Failed to handle message reply", e7);
            }
        }

        public c(e eVar) {
            this.f5316a = eVar;
        }
    }

    public interface d {
        void a(Object obj, e eVar);
    }

    public interface e {
        void a(Object obj);
    }

    public a(V4.b bVar, String str, h hVar) {
        this(bVar, str, hVar, null);
    }

    public void c(Object obj) {
        d(obj, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void d(Object obj, e eVar) {
        this.f5308a.d(this.f5309b, this.f5310c.a(obj), eVar != null ? new c(eVar) : null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [V4.b] */
    /* JADX WARN: Type inference failed for: r1v0, types: [V4.a$a] */
    /* JADX WARN: Type inference failed for: r1v1, types: [V4.b$a] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void e(d dVar) {
        if (this.f5311d != null) {
            this.f5308a.e(this.f5309b, dVar != null ? new b(dVar) : null, this.f5311d);
        } else {
            this.f5308a.b(this.f5309b, dVar != null ? new b(dVar) : 0);
        }
    }

    public a(V4.b bVar, String str, h hVar, b.c cVar) {
        this.f5308a = bVar;
        this.f5309b = str;
        this.f5310c = hVar;
        this.f5311d = cVar;
    }
}
