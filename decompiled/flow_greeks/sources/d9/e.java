package d9;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.protobuf.i f7863a;

    public e(com.google.protobuf.i iVar) {
        this.f7863a = iVar;
    }

    public static e b(com.google.protobuf.i iVar) {
        n9.x.c(iVar, "Provided ByteString must not be null.");
        return new e(iVar);
    }

    public static e c(byte[] bArr) {
        n9.x.c(bArr, "Provided bytes array must not be null.");
        return new e(com.google.protobuf.i.r(bArr));
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(e eVar) {
        return n9.g0.j(this.f7863a, eVar.f7863a);
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && this.f7863a.equals(((e) obj).f7863a);
    }

    public com.google.protobuf.i h() {
        return this.f7863a;
    }

    public int hashCode() {
        return this.f7863a.hashCode();
    }

    public byte[] i() {
        return this.f7863a.Y();
    }

    public String toString() {
        return "Blob { bytes=" + n9.g0.v(this.f7863a) + " }";
    }
}
