package androidx.media;

import android.media.AudioAttributes;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AudioAttributes f2499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2500b = -1;

    public boolean equals(Object obj) {
        if (obj instanceof AudioAttributesImplApi21) {
            return this.f2499a.equals(((AudioAttributesImplApi21) obj).f2499a);
        }
        return false;
    }

    public int hashCode() {
        return this.f2499a.hashCode();
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f2499a;
    }
}
