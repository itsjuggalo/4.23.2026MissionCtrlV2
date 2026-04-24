package W0;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import q1.AbstractC2629l;
import q1.C2625h;

/* JADX INFO: loaded from: classes.dex */
public final class x implements U0.f {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final C2625h f9236j = new C2625h(50);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final X0.b f9237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final U0.f f9238c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final U0.f f9239d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f9240e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f9241f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Class f9242g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final U0.h f9243h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final U0.l f9244i;

    public x(X0.b bVar, U0.f fVar, U0.f fVar2, int i8, int i9, U0.l lVar, Class cls, U0.h hVar) {
        this.f9237b = bVar;
        this.f9238c = fVar;
        this.f9239d = fVar2;
        this.f9240e = i8;
        this.f9241f = i9;
        this.f9244i = lVar;
        this.f9242g = cls;
        this.f9243h = hVar;
    }

    @Override // U0.f
    public void a(MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f9237b.c(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f9240e).putInt(this.f9241f).array();
        this.f9239d.a(messageDigest);
        this.f9238c.a(messageDigest);
        messageDigest.update(bArr);
        U0.l lVar = this.f9244i;
        if (lVar != null) {
            lVar.a(messageDigest);
        }
        this.f9243h.a(messageDigest);
        messageDigest.update(c());
        this.f9237b.d(bArr);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final byte[] c() {
        C2625h c2625h = f9236j;
        byte[] bArr = (byte[]) c2625h.g(this.f9242g);
        if (bArr != null) {
            return bArr;
        }
        byte[] bytes = this.f9242g.getName().getBytes(U0.f.f8077a);
        c2625h.k(this.f9242g, bytes);
        return bytes;
    }

    @Override // U0.f
    public boolean equals(Object obj) {
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return this.f9241f == xVar.f9241f && this.f9240e == xVar.f9240e && AbstractC2629l.d(this.f9244i, xVar.f9244i) && this.f9242g.equals(xVar.f9242g) && this.f9238c.equals(xVar.f9238c) && this.f9239d.equals(xVar.f9239d) && this.f9243h.equals(xVar.f9243h);
    }

    @Override // U0.f
    public int hashCode() {
        int iHashCode = (((((this.f9238c.hashCode() * 31) + this.f9239d.hashCode()) * 31) + this.f9240e) * 31) + this.f9241f;
        U0.l lVar = this.f9244i;
        if (lVar != null) {
            iHashCode = (iHashCode * 31) + lVar.hashCode();
        }
        return (((iHashCode * 31) + this.f9242g.hashCode()) * 31) + this.f9243h.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f9238c + ", signature=" + this.f9239d + ", width=" + this.f9240e + ", height=" + this.f9241f + ", decodedResourceClass=" + this.f9242g + ", transformation='" + this.f9244i + "', options=" + this.f9243h + '}';
    }
}
