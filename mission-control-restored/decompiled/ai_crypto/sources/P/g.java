package P;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f4244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f4245b;

    public g(float f7, float f8) {
        this.f4244a = f.b(f7, "width");
        this.f4245b = f.b(f8, "height");
    }

    public float a() {
        return this.f4245b;
    }

    public float b() {
        return this.f4244a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return gVar.f4244a == this.f4244a && gVar.f4245b == this.f4245b;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f4244a) ^ Float.floatToIntBits(this.f4245b);
    }

    public String toString() {
        return this.f4244a + "x" + this.f4245b;
    }
}
