package tf;

import fe.g1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bf.c f21967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ze.c f21968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bf.a f21969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g1 f21970d;

    public i(bf.c nameResolver, ze.c classProto, bf.a metadataVersion, g1 sourceElement) {
        kotlin.jvm.internal.t.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.t.f(classProto, "classProto");
        kotlin.jvm.internal.t.f(metadataVersion, "metadataVersion");
        kotlin.jvm.internal.t.f(sourceElement, "sourceElement");
        this.f21967a = nameResolver;
        this.f21968b = classProto;
        this.f21969c = metadataVersion;
        this.f21970d = sourceElement;
    }

    public final bf.c a() {
        return this.f21967a;
    }

    public final ze.c b() {
        return this.f21968b;
    }

    public final bf.a c() {
        return this.f21969c;
    }

    public final g1 d() {
        return this.f21970d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return kotlin.jvm.internal.t.b(this.f21967a, iVar.f21967a) && kotlin.jvm.internal.t.b(this.f21968b, iVar.f21968b) && kotlin.jvm.internal.t.b(this.f21969c, iVar.f21969c) && kotlin.jvm.internal.t.b(this.f21970d, iVar.f21970d);
    }

    public int hashCode() {
        return (((((this.f21967a.hashCode() * 31) + this.f21968b.hashCode()) * 31) + this.f21969c.hashCode()) * 31) + this.f21970d.hashCode();
    }

    public String toString() {
        return "ClassData(nameResolver=" + this.f21967a + ", classProto=" + this.f21968b + ", metadataVersion=" + this.f21969c + ", sourceElement=" + this.f21970d + ')';
    }
}
