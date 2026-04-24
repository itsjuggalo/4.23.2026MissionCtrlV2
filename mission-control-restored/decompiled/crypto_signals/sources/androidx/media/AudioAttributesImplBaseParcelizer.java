package androidx.media;

import u0.AbstractC1198a;

/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(AbstractC1198a abstractC1198a) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f4707a = abstractC1198a.f(audioAttributesImplBase.f4707a, 1);
        audioAttributesImplBase.f4708b = abstractC1198a.f(audioAttributesImplBase.f4708b, 2);
        audioAttributesImplBase.f4709c = abstractC1198a.f(audioAttributesImplBase.f4709c, 3);
        audioAttributesImplBase.f4710d = abstractC1198a.f(audioAttributesImplBase.f4710d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, AbstractC1198a abstractC1198a) {
        abstractC1198a.getClass();
        abstractC1198a.j(audioAttributesImplBase.f4707a, 1);
        abstractC1198a.j(audioAttributesImplBase.f4708b, 2);
        abstractC1198a.j(audioAttributesImplBase.f4709c, 3);
        abstractC1198a.j(audioAttributesImplBase.f4710d, 4);
    }
}
