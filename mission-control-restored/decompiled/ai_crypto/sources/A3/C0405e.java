package A3;

import com.google.protobuf.AbstractC1240i;

/* JADX INFO: renamed from: A3.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0405e implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC1240i f174a;

    public C0405e(AbstractC1240i abstractC1240i) {
        this.f174a = abstractC1240i;
    }

    public static C0405e b(AbstractC1240i abstractC1240i) {
        K3.z.c(abstractC1240i, "Provided ByteString must not be null.");
        return new C0405e(abstractC1240i);
    }

    public static C0405e c(byte[] bArr) {
        K3.z.c(bArr, "Provided bytes array must not be null.");
        return new C0405e(AbstractC1240i.m(bArr));
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C0405e c0405e) {
        return K3.I.j(this.f174a, c0405e.f174a);
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0405e) && this.f174a.equals(((C0405e) obj).f174a);
    }

    public AbstractC1240i h() {
        return this.f174a;
    }

    public int hashCode() {
        return this.f174a.hashCode();
    }

    public byte[] i() {
        return this.f174a.F();
    }

    public String toString() {
        return "Blob { bytes=" + K3.I.C(this.f174a) + " }";
    }
}
