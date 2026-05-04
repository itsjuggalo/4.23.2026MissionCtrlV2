package androidx.media;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplBase implements AudioAttributesImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2501a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2502b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2503c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2504d = -1;

    public int a() {
        return this.f2502b;
    }

    public int b() {
        int i10 = this.f2503c;
        int iC = c();
        if (iC == 6) {
            i10 |= 4;
        } else if (iC == 7) {
            i10 |= 1;
        }
        return i10 & 273;
    }

    public int c() {
        int i10 = this.f2504d;
        return i10 != -1 ? i10 : AudioAttributesCompat.a(false, this.f2503c, this.f2501a);
    }

    public int d() {
        return this.f2501a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        return this.f2502b == audioAttributesImplBase.a() && this.f2503c == audioAttributesImplBase.b() && this.f2501a == audioAttributesImplBase.d() && this.f2504d == audioAttributesImplBase.f2504d;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f2502b), Integer.valueOf(this.f2503c), Integer.valueOf(this.f2501a), Integer.valueOf(this.f2504d)});
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("AudioAttributesCompat:");
        if (this.f2504d != -1) {
            sb2.append(" stream=");
            sb2.append(this.f2504d);
            sb2.append(" derived");
        }
        sb2.append(" usage=");
        sb2.append(AudioAttributesCompat.b(this.f2501a));
        sb2.append(" content=");
        sb2.append(this.f2502b);
        sb2.append(" flags=0x");
        sb2.append(Integer.toHexString(this.f2503c).toUpperCase());
        return sb2.toString();
    }
}
