package androidx.media;

import android.media.AudioAttributes;

/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AudioAttributes f7731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7732b = -1;

    public boolean equals(Object obj) {
        if (obj instanceof AudioAttributesImplApi21) {
            return this.f7731a.equals(((AudioAttributesImplApi21) obj).f7731a);
        }
        return false;
    }

    public int hashCode() {
        return this.f7731a.hashCode();
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f7731a;
    }
}
