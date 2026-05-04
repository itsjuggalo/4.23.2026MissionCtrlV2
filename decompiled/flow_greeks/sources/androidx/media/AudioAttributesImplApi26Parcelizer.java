package androidx.media;

import android.media.AudioAttributes;
import p2.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplApi26Parcelizer {
    public static AudioAttributesImplApi26 read(a aVar) {
        AudioAttributesImplApi26 audioAttributesImplApi26 = new AudioAttributesImplApi26();
        audioAttributesImplApi26.f2499a = (AudioAttributes) aVar.r(audioAttributesImplApi26.f2499a, 1);
        audioAttributesImplApi26.f2500b = aVar.p(audioAttributesImplApi26.f2500b, 2);
        return audioAttributesImplApi26;
    }

    public static void write(AudioAttributesImplApi26 audioAttributesImplApi26, a aVar) {
        aVar.x(false, false);
        aVar.H(audioAttributesImplApi26.f2499a, 1);
        aVar.F(audioAttributesImplApi26.f2500b, 2);
    }
}
