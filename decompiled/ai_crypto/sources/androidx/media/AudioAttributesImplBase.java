package androidx.media;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplBase implements AudioAttributesImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7842a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7843b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7844c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7845d = -1;

    public int a() {
        return this.f7843b;
    }

    public int b() {
        int i7 = this.f7844c;
        int iC = c();
        if (iC == 6) {
            i7 |= 4;
        } else if (iC == 7) {
            i7 |= 1;
        }
        return i7 & 273;
    }

    public int c() {
        int i7 = this.f7845d;
        return i7 != -1 ? i7 : AudioAttributesCompat.a(false, this.f7844c, this.f7842a);
    }

    public int d() {
        return this.f7842a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        return this.f7843b == audioAttributesImplBase.a() && this.f7844c == audioAttributesImplBase.b() && this.f7842a == audioAttributesImplBase.d() && this.f7845d == audioAttributesImplBase.f7845d;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f7843b), Integer.valueOf(this.f7844c), Integer.valueOf(this.f7842a), Integer.valueOf(this.f7845d)});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f7845d != -1) {
            sb.append(" stream=");
            sb.append(this.f7845d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.b(this.f7842a));
        sb.append(" content=");
        sb.append(this.f7843b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f7844c).toUpperCase());
        return sb.toString();
    }
}
