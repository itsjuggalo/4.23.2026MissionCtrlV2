package V6;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class n implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f9018b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pattern f9019a;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public n(String pattern) {
        AbstractC2304t.f(pattern, "pattern");
        Pattern patternCompile = Pattern.compile(pattern);
        AbstractC2304t.e(patternCompile, "compile(...)");
        this(patternCompile);
    }

    public final k a(CharSequence input) {
        AbstractC2304t.f(input, "input");
        Matcher matcher = this.f9019a.matcher(input);
        AbstractC2304t.e(matcher, "matcher(...)");
        return o.c(matcher, input);
    }

    public final boolean b(CharSequence input) {
        AbstractC2304t.f(input, "input");
        return this.f9019a.matcher(input).matches();
    }

    public final String c(CharSequence input, String replacement) {
        AbstractC2304t.f(input, "input");
        AbstractC2304t.f(replacement, "replacement");
        String strReplaceAll = this.f9019a.matcher(input).replaceAll(replacement);
        AbstractC2304t.e(strReplaceAll, "replaceAll(...)");
        return strReplaceAll;
    }

    public String toString() {
        String string = this.f9019a.toString();
        AbstractC2304t.e(string, "toString(...)");
        return string;
    }

    public n(Pattern nativePattern) {
        AbstractC2304t.f(nativePattern, "nativePattern");
        this.f9019a = nativePattern;
    }
}
