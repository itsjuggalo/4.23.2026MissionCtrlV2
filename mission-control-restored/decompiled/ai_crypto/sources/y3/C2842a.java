package y3;

import y3.d;

/* JADX INFO: renamed from: y3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2842a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f25641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d.a f25642b = d.a.DEFAULT;

    /* JADX INFO: renamed from: y3.a$a, reason: collision with other inner class name */
    public static final class C0396a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f25643a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d.a f25644b;

        public C0396a(int i7, d.a aVar) {
            this.f25643a = i7;
            this.f25644b = aVar;
        }

        @Override // java.lang.annotation.Annotation
        public Class annotationType() {
            return d.class;
        }

        @Override // java.lang.annotation.Annotation
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f25643a == dVar.tag() && this.f25644b.equals(dVar.intEncoding());
        }

        @Override // java.lang.annotation.Annotation
        public int hashCode() {
            return (14552422 ^ this.f25643a) + (this.f25644b.hashCode() ^ 2041407134);
        }

        @Override // y3.d
        public d.a intEncoding() {
            return this.f25644b;
        }

        @Override // y3.d
        public int tag() {
            return this.f25643a;
        }

        @Override // java.lang.annotation.Annotation
        public String toString() {
            return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.f25643a + "intEncoding=" + this.f25644b + ')';
        }
    }

    public static C2842a b() {
        return new C2842a();
    }

    public d a() {
        return new C0396a(this.f25641a, this.f25642b);
    }

    public C2842a c(int i7) {
        this.f25641a = i7;
        return this;
    }
}
