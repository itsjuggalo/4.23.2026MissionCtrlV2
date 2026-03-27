package androidx.media;

import android.media.AudioAttributes;
import u0.AbstractC1198a;

/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(AbstractC1198a abstractC1198a) {
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        audioAttributesImplApi21.f4705a = (AudioAttributes) abstractC1198a.g(audioAttributesImplApi21.f4705a, 1);
        audioAttributesImplApi21.f4706b = abstractC1198a.f(audioAttributesImplApi21.f4706b, 2);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, AbstractC1198a abstractC1198a) {
        abstractC1198a.getClass();
        abstractC1198a.k(audioAttributesImplApi21.f4705a, 1);
        abstractC1198a.j(audioAttributesImplApi21.f4706b, 2);
    }
}
