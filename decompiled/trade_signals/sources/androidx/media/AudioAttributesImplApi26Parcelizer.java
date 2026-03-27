package androidx.media;

import E0.a;
import android.media.AudioAttributes;

/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplApi26Parcelizer {
    public static AudioAttributesImplApi26 read(a aVar) {
        AudioAttributesImplApi26 audioAttributesImplApi26 = new AudioAttributesImplApi26();
        audioAttributesImplApi26.f12027a = (AudioAttributes) aVar.r(audioAttributesImplApi26.f12027a, 1);
        audioAttributesImplApi26.f12028b = aVar.p(audioAttributesImplApi26.f12028b, 2);
        return audioAttributesImplApi26;
    }

    public static void write(AudioAttributesImplApi26 audioAttributesImplApi26, a aVar) {
        aVar.x(false, false);
        aVar.H(audioAttributesImplApi26.f12027a, 1);
        aVar.F(audioAttributesImplApi26.f12028b, 2);
    }
}
