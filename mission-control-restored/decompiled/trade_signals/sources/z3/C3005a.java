package z3;

import z3.d;

/* JADX INFO: renamed from: z3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C3005a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f24732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d.a f24733b = d.a.DEFAULT;

    /* JADX INFO: renamed from: z3.a$a, reason: collision with other inner class name */
    public static final class C0440a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f24734a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d.a f24735b;

        public C0440a(int i8, d.a aVar) {
            this.f24734a = i8;
            this.f24735b = aVar;
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
            return this.f24734a == dVar.tag() && this.f24735b.equals(dVar.intEncoding());
        }

        @Override // java.lang.annotation.Annotation
        public int hashCode() {
            return (14552422 ^ this.f24734a) + (this.f24735b.hashCode() ^ 2041407134);
        }

        @Override // z3.d
        public d.a intEncoding() {
            return this.f24735b;
        }

        @Override // z3.d
        public int tag() {
            return this.f24734a;
        }

        @Override // java.lang.annotation.Annotation
        public String toString() {
            return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.f24734a + "intEncoding=" + this.f24735b + ')';
        }
    }

    public static C3005a b() {
        return new C3005a();
    }

    public d a() {
        return new C0440a(this.f24732a, this.f24733b);
    }

    public C3005a c(int i8) {
        this.f24732a = i8;
        return this;
    }
}
