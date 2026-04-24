package androidx.media;

import android.media.AudioAttributes;
import t0.AbstractC1782a;

/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplApi26Parcelizer {
    public static AudioAttributesImplApi26 read(AbstractC1782a abstractC1782a) {
        AudioAttributesImplApi26 audioAttributesImplApi26 = new AudioAttributesImplApi26();
        audioAttributesImplApi26.f7731a = (AudioAttributes) abstractC1782a.r(audioAttributesImplApi26.f7731a, 1);
        audioAttributesImplApi26.f7732b = abstractC1782a.p(audioAttributesImplApi26.f7732b, 2);
        return audioAttributesImplApi26;
    }

    public static void write(AudioAttributesImplApi26 audioAttributesImplApi26, AbstractC1782a abstractC1782a) {
        abstractC1782a.x(false, false);
        abstractC1782a.H(audioAttributesImplApi26.f7731a, 1);
        abstractC1782a.F(audioAttributesImplApi26.f7732b, 2);
    }
}
