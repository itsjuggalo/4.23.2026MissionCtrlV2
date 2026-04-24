package R;

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
        public final TextPaint f6822a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextDirectionHeuristic f6823b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f6824c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f6825d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final PrecomputedText.Params f6826e;

        /* JADX INFO: renamed from: R.l$a$a, reason: collision with other inner class name */
        public static class C0095a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final TextPaint f6827a;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f6829c = 1;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f6830d = 1;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public TextDirectionHeuristic f6828b = TextDirectionHeuristics.FIRSTSTRONG_LTR;

            public C0095a(TextPaint textPaint) {
                this.f6827a = textPaint;
            }

            public a a() {
                return new a(this.f6827a, this.f6828b, this.f6829c, this.f6830d);
            }

            public C0095a b(int i8) {
                this.f6829c = i8;
                return this;
            }

            public C0095a c(int i8) {
                this.f6830d = i8;
                return this;
            }

            public C0095a d(TextDirectionHeuristic textDirectionHeuristic) {
                this.f6828b = textDirectionHeuristic;
                return this;
            }
        }

        public a(PrecomputedText.Params params) {
            this.f6822a = params.getTextPaint();
            this.f6823b = params.getTextDirection();
            this.f6824c = params.getBreakStrategy();
            this.f6825d = params.getHyphenationFrequency();
            this.f6826e = Build.VERSION.SDK_INT < 29 ? null : params;
        }

        public boolean a(a aVar) {
            if (this.f6824c == aVar.b() && this.f6825d == aVar.c() && this.f6822a.getTextSize() == aVar.e().getTextSize() && this.f6822a.getTextScaleX() == aVar.e().getTextScaleX() && this.f6822a.getTextSkewX() == aVar.e().getTextSkewX() && this.f6822a.getLetterSpacing() == aVar.e().getLetterSpacing() && TextUtils.equals(this.f6822a.getFontFeatureSettings(), aVar.e().getFontFeatureSettings()) && this.f6822a.getFlags() == aVar.e().getFlags() && this.f6822a.getTextLocales().equals(aVar.e().getTextLocales())) {
                return this.f6822a.getTypeface() == null ? aVar.e().getTypeface() == null : this.f6822a.getTypeface().equals(aVar.e().getTypeface());
            }
            return false;
        }

        public int b() {
            return this.f6824c;
        }

        public int c() {
            return this.f6825d;
        }

        public TextDirectionHeuristic d() {
            return this.f6823b;
        }

        public TextPaint e() {
            return this.f6822a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return a(aVar) && this.f6823b == aVar.d();
        }

        public int hashCode() {
            return S.c.b(Float.valueOf(this.f6822a.getTextSize()), Float.valueOf(this.f6822a.getTextScaleX()), Float.valueOf(this.f6822a.getTextSkewX()), Float.valueOf(this.f6822a.getLetterSpacing()), Integer.valueOf(this.f6822a.getFlags()), this.f6822a.getTextLocales(), this.f6822a.getTypeface(), Boolean.valueOf(this.f6822a.isElegantTextHeight()), this.f6823b, Integer.valueOf(this.f6824c), Integer.valueOf(this.f6825d));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f6822a.getTextSize());
            sb.append(", textScaleX=" + this.f6822a.getTextScaleX());
            sb.append(", textSkewX=" + this.f6822a.getTextSkewX());
            int i8 = Build.VERSION.SDK_INT;
            sb.append(", letterSpacing=" + this.f6822a.getLetterSpacing());
            sb.append(", elegantTextHeight=" + this.f6822a.isElegantTextHeight());
            sb.append(", textLocale=" + this.f6822a.getTextLocales());
            sb.append(", typeface=" + this.f6822a.getTypeface());
            if (i8 >= 26) {
                sb.append(", variationSettings=" + this.f6822a.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.f6823b);
            sb.append(", breakStrategy=" + this.f6824c);
            sb.append(", hyphenationFrequency=" + this.f6825d);
            sb.append("}");
            return sb.toString();
        }

        public a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i8, int i9) {
            this.f6826e = Build.VERSION.SDK_INT >= 29 ? k.a(textPaint).setBreakStrategy(i8).setHyphenationFrequency(i9).setTextDirection(textDirectionHeuristic).build() : null;
            this.f6822a = textPaint;
            this.f6823b = textDirectionHeuristic;
            this.f6824c = i8;
            this.f6825d = i9;
        }
    }
}
