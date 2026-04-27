package androidx.media;

import u0.AbstractC1198a;
import u0.c;

/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(AbstractC1198a abstractC1198a) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        c cVarH = audioAttributesCompat.f4704a;
        if (abstractC1198a.e(1)) {
            cVarH = abstractC1198a.h();
        }
        audioAttributesCompat.f4704a = (AudioAttributesImpl) cVarH;
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, AbstractC1198a abstractC1198a) {
        abstractC1198a.getClass();
        AudioAttributesImpl audioAttributesImpl = audioAttributesCompat.f4704a;
        abstractC1198a.i(1);
        abstractC1198a.l(audioAttributesImpl);
    }
}
