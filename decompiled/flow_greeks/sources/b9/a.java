package b9;

import b9.d;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d.a f3034b = d.a.DEFAULT;

    /* JADX INFO: renamed from: b9.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0049a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3035a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d.a f3036b;

        public C0049a(int i10, d.a aVar) {
            this.f3035a = i10;
            this.f3036b = aVar;
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
            return this.f3035a == dVar.tag() && this.f3036b.equals(dVar.intEncoding());
        }

        @Override // java.lang.annotation.Annotation
        public int hashCode() {
            return (14552422 ^ this.f3035a) + (this.f3036b.hashCode() ^ 2041407134);
        }

        @Override // b9.d
        public d.a intEncoding() {
            return this.f3036b;
        }

        @Override // b9.d
        public int tag() {
            return this.f3035a;
        }

        @Override // java.lang.annotation.Annotation
        public String toString() {
            return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.f3035a + "intEncoding=" + this.f3036b + ')';
        }
    }

    public static a b() {
        return new a();
    }

    public d a() {
        return new C0049a(this.f3033a, this.f3034b);
    }

    public a c(int i10) {
        this.f3033a = i10;
        return this;
    }
}
