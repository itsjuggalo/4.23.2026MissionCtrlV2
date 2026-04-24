package androidx.media;

import K0.a;

/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(a aVar) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f7842a = aVar.p(audioAttributesImplBase.f7842a, 1);
        audioAttributesImplBase.f7843b = aVar.p(audioAttributesImplBase.f7843b, 2);
        audioAttributesImplBase.f7844c = aVar.p(audioAttributesImplBase.f7844c, 3);
        audioAttributesImplBase.f7845d = aVar.p(audioAttributesImplBase.f7845d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, a aVar) {
        aVar.x(false, false);
        aVar.F(audioAttributesImplBase.f7842a, 1);
        aVar.F(audioAttributesImplBase.f7843b, 2);
        aVar.F(audioAttributesImplBase.f7844c, 3);
        aVar.F(audioAttributesImplBase.f7845d, 4);
    }
}
