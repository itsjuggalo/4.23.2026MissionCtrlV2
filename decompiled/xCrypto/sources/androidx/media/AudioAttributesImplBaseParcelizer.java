package androidx.media;

import t0.AbstractC1782a;

/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(AbstractC1782a abstractC1782a) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f7733a = abstractC1782a.p(audioAttributesImplBase.f7733a, 1);
        audioAttributesImplBase.f7734b = abstractC1782a.p(audioAttributesImplBase.f7734b, 2);
        audioAttributesImplBase.f7735c = abstractC1782a.p(audioAttributesImplBase.f7735c, 3);
        audioAttributesImplBase.f7736d = abstractC1782a.p(audioAttributesImplBase.f7736d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, AbstractC1782a abstractC1782a) {
        abstractC1782a.x(false, false);
        abstractC1782a.F(audioAttributesImplBase.f7733a, 1);
        abstractC1782a.F(audioAttributesImplBase.f7734b, 2);
        abstractC1782a.F(audioAttributesImplBase.f7735c, 3);
        abstractC1782a.F(audioAttributesImplBase.f7736d, 4);
    }
}
