package androidx.media;

import android.media.AudioAttributes;
import p2.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(a aVar) {
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        audioAttributesImplApi21.f2499a = (AudioAttributes) aVar.r(audioAttributesImplApi21.f2499a, 1);
        audioAttributesImplApi21.f2500b = aVar.p(audioAttributesImplApi21.f2500b, 2);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, a aVar) {
        aVar.x(false, false);
        aVar.H(audioAttributesImplApi21.f2499a, 1);
        aVar.F(audioAttributesImplApi21.f2500b, 2);
    }
}
