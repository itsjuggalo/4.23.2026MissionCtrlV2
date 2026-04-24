package androidx.media;

import android.media.AudioAttributes;
import t0.AbstractC1782a;

/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(AbstractC1782a abstractC1782a) {
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        audioAttributesImplApi21.f7731a = (AudioAttributes) abstractC1782a.r(audioAttributesImplApi21.f7731a, 1);
        audioAttributesImplApi21.f7732b = abstractC1782a.p(audioAttributesImplApi21.f7732b, 2);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, AbstractC1782a abstractC1782a) {
        abstractC1782a.x(false, false);
        abstractC1782a.H(audioAttributesImplApi21.f7731a, 1);
        abstractC1782a.F(audioAttributesImplApi21.f7732b, 2);
    }
}
