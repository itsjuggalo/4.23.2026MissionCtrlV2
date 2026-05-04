package i3;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class x implements g3.f {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final c4.h f11775j = new c4.h(50);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j3.b f11776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g3.f f11777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g3.f f11778d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f11779e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f11780f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Class f11781g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final g3.h f11782h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final g3.l f11783i;

    public x(j3.b bVar, g3.f fVar, g3.f fVar2, int i10, int i11, g3.l lVar, Class cls, g3.h hVar) {
        this.f11776b = bVar;
        this.f11777c = fVar;
        this.f11778d = fVar2;
        this.f11779e = i10;
        this.f11780f = i11;
        this.f11783i = lVar;
        this.f11781g = cls;
        this.f11782h = hVar;
    }

    @Override // g3.f
    public void b(MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f11776b.c(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f11779e).putInt(this.f11780f).array();
        this.f11778d.b(messageDigest);
        this.f11777c.b(messageDigest);
        messageDigest.update(bArr);
        g3.l lVar = this.f11783i;
        if (lVar != null) {
            lVar.b(messageDigest);
        }
        this.f11782h.b(messageDigest);
        messageDigest.update(c());
        this.f11776b.put(bArr);
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
        c4.h hVar = f11775j;
        byte[] bArr = (byte[]) hVar.g(this.f11781g);
        if (bArr != null) {
            return bArr;
        }
        byte[] bytes = this.f11781g.getName().getBytes(g3.f.f10026a);
        hVar.k(this.f11781g, bytes);
        return bytes;
    }

    @Override // g3.f
    public boolean equals(Object obj) {
        if (obj instanceof x) {
            x xVar = (x) obj;
            if (this.f11780f == xVar.f11780f && this.f11779e == xVar.f11779e && c4.l.d(this.f11783i, xVar.f11783i) && this.f11781g.equals(xVar.f11781g) && this.f11777c.equals(xVar.f11777c) && this.f11778d.equals(xVar.f11778d) && this.f11782h.equals(xVar.f11782h)) {
                return true;
            }
        }
        return false;
    }

    @Override // g3.f
    public int hashCode() {
        int iHashCode = (((((this.f11777c.hashCode() * 31) + this.f11778d.hashCode()) * 31) + this.f11779e) * 31) + this.f11780f;
        g3.l lVar = this.f11783i;
        if (lVar != null) {
            iHashCode = (iHashCode * 31) + lVar.hashCode();
        }
        return (((iHashCode * 31) + this.f11781g.hashCode()) * 31) + this.f11782h.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f11777c + ", signature=" + this.f11778d + ", width=" + this.f11779e + ", height=" + this.f11780f + ", decodedResourceClass=" + this.f11781g + ", transformation='" + this.f11783i + "', options=" + this.f11782h + '}';
    }
}
