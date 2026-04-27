package F;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class l implements Spannable {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextPaint f421a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextDirectionHeuristic f422b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f423c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f424d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final PrecomputedText.Params f425e;

        /* JADX INFO: renamed from: F.l$a$a, reason: collision with other inner class name */
        public static class C0019a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final TextPaint f426a;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f428c = 1;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f429d = 1;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public TextDirectionHeuristic f427b = TextDirectionHeuristics.FIRSTSTRONG_LTR;

            public C0019a(TextPaint textPaint) {
                this.f426a = textPaint;
            }

            public a a() {
                return new a(this.f426a, this.f427b, this.f428c, this.f429d);
            }

            public C0019a b(int i4) {
                this.f428c = i4;
                return this;
            }

            public C0019a c(int i4) {
                this.f429d = i4;
                return this;
            }

            public C0019a d(TextDirectionHeuristic textDirectionHeuristic) {
                this.f427b = textDirectionHeuristic;
                return this;
            }
        }

        public a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i4, int i5) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f425e = k.a(textPaint).setBreakStrategy(i4).setHyphenationFrequency(i5).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.f425e = null;
            }
            this.f421a = textPaint;
            this.f422b = textDirectionHeuristic;
            this.f423c = i4;
            this.f424d = i5;
        }

        public boolean a(a aVar) {
            if (this.f423c == aVar.b() && this.f424d == aVar.c() && this.f421a.getTextSize() == aVar.e().getTextSize() && this.f421a.getTextScaleX() == aVar.e().getTextScaleX() && this.f421a.getTextSkewX() == aVar.e().getTextSkewX() && this.f421a.getLetterSpacing() == aVar.e().getLetterSpacing() && TextUtils.equals(this.f421a.getFontFeatureSettings(), aVar.e().getFontFeatureSettings()) && this.f421a.getFlags() == aVar.e().getFlags() && this.f421a.getTextLocales().equals(aVar.e().getTextLocales())) {
                return this.f421a.getTypeface() == null ? aVar.e().getTypeface() == null : this.f421a.getTypeface().equals(aVar.e().getTypeface());
            }
            return false;
        }

        public int b() {
            return this.f423c;
        }

        public int c() {
            return this.f424d;
        }

        public TextDirectionHeuristic d() {
            return this.f422b;
        }

        public TextPaint e() {
            return this.f421a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return a(aVar) && this.f422b == aVar.d();
        }

        public int hashCode() {
            return G.b.b(Float.valueOf(this.f421a.getTextSize()), Float.valueOf(this.f421a.getTextScaleX()), Float.valueOf(this.f421a.getTextSkewX()), Float.valueOf(this.f421a.getLetterSpacing()), Integer.valueOf(this.f421a.getFlags()), this.f421a.getTextLocales(), this.f421a.getTypeface(), Boolean.valueOf(this.f421a.isElegantTextHeight()), this.f422b, Integer.valueOf(this.f423c), Integer.valueOf(this.f424d));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f421a.getTextSize());
            sb.append(", textScaleX=" + this.f421a.getTextScaleX());
            sb.append(", textSkewX=" + this.f421a.getTextSkewX());
            int i4 = Build.VERSION.SDK_INT;
            sb.append(", letterSpacing=" + this.f421a.getLetterSpacing());
            sb.append(", elegantTextHeight=" + this.f421a.isElegantTextHeight());
            sb.append(", textLocale=" + this.f421a.getTextLocales());
            sb.append(", typeface=" + this.f421a.getTypeface());
            if (i4 >= 26) {
                sb.append(", variationSettings=" + this.f421a.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.f422b);
            sb.append(", breakStrategy=" + this.f423c);
            sb.append(", hyphenationFrequency=" + this.f424d);
            sb.append("}");
            return sb.toString();
        }

        public a(PrecomputedText.Params params) {
            this.f421a = params.getTextPaint();
            this.f422b = params.getTextDirection();
            this.f423c = params.getBreakStrategy();
            this.f424d = params.getHyphenationFrequency();
            this.f425e = Build.VERSION.SDK_INT < 29 ? null : params;
        }
    }
}
