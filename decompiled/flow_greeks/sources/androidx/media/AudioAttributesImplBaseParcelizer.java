package androidx.media;

import p2.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(a aVar) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f2501a = aVar.p(audioAttributesImplBase.f2501a, 1);
        audioAttributesImplBase.f2502b = aVar.p(audioAttributesImplBase.f2502b, 2);
        audioAttributesImplBase.f2503c = aVar.p(audioAttributesImplBase.f2503c, 3);
        audioAttributesImplBase.f2504d = aVar.p(audioAttributesImplBase.f2504d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, a aVar) {
        aVar.x(false, false);
        aVar.F(audioAttributesImplBase.f2501a, 1);
        aVar.F(audioAttributesImplBase.f2502b, 2);
        aVar.F(audioAttributesImplBase.f2503c, 3);
        aVar.F(audioAttributesImplBase.f2504d, 4);
    }
}
