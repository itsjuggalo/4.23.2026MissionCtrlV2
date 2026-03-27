package androidx.media;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplBase implements AudioAttributesImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12029a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12030b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12031c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12032d = -1;

    public int a() {
        return this.f12030b;
    }

    public int b() {
        int i8 = this.f12031c;
        int iC = c();
        if (iC == 6) {
            i8 |= 4;
        } else if (iC == 7) {
            i8 |= 1;
        }
        return i8 & 273;
    }

    public int c() {
        int i8 = this.f12032d;
        return i8 != -1 ? i8 : AudioAttributesCompat.a(false, this.f12031c, this.f12029a);
    }

    public int d() {
        return this.f12029a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        return this.f12030b == audioAttributesImplBase.a() && this.f12031c == audioAttributesImplBase.b() && this.f12029a == audioAttributesImplBase.d() && this.f12032d == audioAttributesImplBase.f12032d;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f12030b), Integer.valueOf(this.f12031c), Integer.valueOf(this.f12029a), Integer.valueOf(this.f12032d)});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f12032d != -1) {
            sb.append(" stream=");
            sb.append(this.f12032d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.b(this.f12029a));
        sb.append(" content=");
        sb.append(this.f12030b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f12031c).toUpperCase());
        return sb.toString();
    }
}
