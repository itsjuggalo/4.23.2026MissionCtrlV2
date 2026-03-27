package B;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextPaint f71a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextDirectionHeuristic f72b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f73c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f74d;

    public d(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i, int i6) {
        if (Build.VERSION.SDK_INT >= 29) {
            c.f(textPaint).setBreakStrategy(i).setHyphenationFrequency(i6).setTextDirection(textDirectionHeuristic).build();
        }
        this.f71a = textPaint;
        this.f72b = textDirectionHeuristic;
        this.f73c = i;
        this.f74d = i6;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f73c != dVar.f73c || this.f74d != dVar.f74d) {
            return false;
        }
        TextPaint textPaint = this.f71a;
        float textSize = textPaint.getTextSize();
        TextPaint textPaint2 = dVar.f71a;
        if (textSize != textPaint2.getTextSize() || textPaint.getTextScaleX() != textPaint2.getTextScaleX() || textPaint.getTextSkewX() != textPaint2.getTextSkewX() || textPaint.getLetterSpacing() != textPaint2.getLetterSpacing() || !TextUtils.equals(textPaint.getFontFeatureSettings(), textPaint2.getFontFeatureSettings()) || textPaint.getFlags() != textPaint2.getFlags() || !textPaint.getTextLocales().equals(textPaint2.getTextLocales())) {
            return false;
        }
        if (textPaint.getTypeface() == null) {
            if (textPaint2.getTypeface() != null) {
                return false;
            }
        } else if (!textPaint.getTypeface().equals(textPaint2.getTypeface())) {
            return false;
        }
        return this.f72b == dVar.f72b;
    }

    public final int hashCode() {
        TextPaint textPaint = this.f71a;
        return Objects.hash(Float.valueOf(textPaint.getTextSize()), Float.valueOf(textPaint.getTextScaleX()), Float.valueOf(textPaint.getTextSkewX()), Float.valueOf(textPaint.getLetterSpacing()), Integer.valueOf(textPaint.getFlags()), textPaint.getTextLocales(), textPaint.getTypeface(), Boolean.valueOf(textPaint.isElegantTextHeight()), this.f72b, Integer.valueOf(this.f73c), Integer.valueOf(this.f74d));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{");
        StringBuilder sb2 = new StringBuilder("textSize=");
        TextPaint textPaint = this.f71a;
        sb2.append(textPaint.getTextSize());
        sb.append(sb2.toString());
        sb.append(", textScaleX=" + textPaint.getTextScaleX());
        sb.append(", textSkewX=" + textPaint.getTextSkewX());
        int i = Build.VERSION.SDK_INT;
        sb.append(", letterSpacing=" + textPaint.getLetterSpacing());
        sb.append(", elegantTextHeight=" + textPaint.isElegantTextHeight());
        sb.append(", textLocale=" + textPaint.getTextLocales());
        sb.append(", typeface=" + textPaint.getTypeface());
        if (i >= 26) {
            sb.append(", variationSettings=" + textPaint.getFontVariationSettings());
        }
        sb.append(", textDir=" + this.f72b);
        sb.append(", breakStrategy=" + this.f73c);
        sb.append(", hyphenationFrequency=" + this.f74d);
        sb.append("}");
        return sb.toString();
    }

    public d(PrecomputedText.Params params) {
        this.f71a = params.getTextPaint();
        this.f72b = params.getTextDirection();
        this.f73c = params.getBreakStrategy();
        this.f74d = params.getHyphenationFrequency();
    }
}
