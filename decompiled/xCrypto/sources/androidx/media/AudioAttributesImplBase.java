package androidx.media;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplBase implements AudioAttributesImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7733a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7734b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7735c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7736d = -1;

    public int a() {
        return this.f7734b;
    }

    public int b() {
        int i4 = this.f7735c;
        int iC = c();
        if (iC == 6) {
            i4 |= 4;
        } else if (iC == 7) {
            i4 |= 1;
        }
        return i4 & 273;
    }

    public int c() {
        int i4 = this.f7736d;
        return i4 != -1 ? i4 : AudioAttributesCompat.a(false, this.f7735c, this.f7733a);
    }

    public int d() {
        return this.f7733a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        return this.f7734b == audioAttributesImplBase.a() && this.f7735c == audioAttributesImplBase.b() && this.f7733a == audioAttributesImplBase.d() && this.f7736d == audioAttributesImplBase.f7736d;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f7734b), Integer.valueOf(this.f7735c), Integer.valueOf(this.f7733a), Integer.valueOf(this.f7736d)});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f7736d != -1) {
            sb.append(" stream=");
            sb.append(this.f7736d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.b(this.f7733a));
        sb.append(" content=");
        sb.append(this.f7734b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f7735c).toUpperCase());
        return sb.toString();
    }
}
