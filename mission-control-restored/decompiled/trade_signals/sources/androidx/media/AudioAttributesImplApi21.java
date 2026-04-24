package androidx.media;

import android.media.AudioAttributes;

/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AudioAttributes f12027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12028b = -1;

    public boolean equals(Object obj) {
        if (obj instanceof AudioAttributesImplApi21) {
            return this.f12027a.equals(((AudioAttributesImplApi21) obj).f12027a);
        }
        return false;
    }

    public int hashCode() {
        return this.f12027a.hashCode();
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f12027a;
    }
}
