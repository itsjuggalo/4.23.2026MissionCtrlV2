package androidx.media;

import android.media.AudioAttributes;
import u0.AbstractC1198a;

/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplApi26Parcelizer {
    public static AudioAttributesImplApi26 read(AbstractC1198a abstractC1198a) {
        AudioAttributesImplApi26 audioAttributesImplApi26 = new AudioAttributesImplApi26();
        audioAttributesImplApi26.f4705a = (AudioAttributes) abstractC1198a.g(audioAttributesImplApi26.f4705a, 1);
        audioAttributesImplApi26.f4706b = abstractC1198a.f(audioAttributesImplApi26.f4706b, 2);
        return audioAttributesImplApi26;
    }

    public static void write(AudioAttributesImplApi26 audioAttributesImplApi26, AbstractC1198a abstractC1198a) {
        abstractC1198a.getClass();
        abstractC1198a.k(audioAttributesImplApi26.f4705a, 1);
        abstractC1198a.j(audioAttributesImplApi26.f4706b, 2);
    }
}
