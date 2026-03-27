package androidx.media;

import E0.a;

/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(a aVar) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f12029a = aVar.p(audioAttributesImplBase.f12029a, 1);
        audioAttributesImplBase.f12030b = aVar.p(audioAttributesImplBase.f12030b, 2);
        audioAttributesImplBase.f12031c = aVar.p(audioAttributesImplBase.f12031c, 3);
        audioAttributesImplBase.f12032d = aVar.p(audioAttributesImplBase.f12032d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, a aVar) {
        aVar.x(false, false);
        aVar.F(audioAttributesImplBase.f12029a, 1);
        aVar.F(audioAttributesImplBase.f12030b, 2);
        aVar.F(audioAttributesImplBase.f12031c, 3);
        aVar.F(audioAttributesImplBase.f12032d, 4);
    }
}
