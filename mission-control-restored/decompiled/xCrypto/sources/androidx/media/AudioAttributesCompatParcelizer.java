package androidx.media;

import t0.AbstractC1782a;

/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(AbstractC1782a abstractC1782a) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.f7730a = (AudioAttributesImpl) abstractC1782a.v(audioAttributesCompat.f7730a, 1);
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, AbstractC1782a abstractC1782a) {
        abstractC1782a.x(false, false);
        abstractC1782a.M(audioAttributesCompat.f7730a, 1);
    }
}
