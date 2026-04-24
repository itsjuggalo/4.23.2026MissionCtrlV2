package Z5;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f6044b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pattern f6045a;

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public a() {
        }
    }

    public i(Pattern nativePattern) {
        kotlin.jvm.internal.r.f(nativePattern, "nativePattern");
        this.f6045a = nativePattern;
    }

    public final g a(CharSequence input) {
        kotlin.jvm.internal.r.f(input, "input");
        Matcher matcher = this.f6045a.matcher(input);
        kotlin.jvm.internal.r.e(matcher, "matcher(...)");
        return j.c(matcher, input);
    }

    public final boolean b(CharSequence input) {
        kotlin.jvm.internal.r.f(input, "input");
        return this.f6045a.matcher(input).matches();
    }

    public final String c(CharSequence input, String replacement) {
        kotlin.jvm.internal.r.f(input, "input");
        kotlin.jvm.internal.r.f(replacement, "replacement");
        String strReplaceAll = this.f6045a.matcher(input).replaceAll(replacement);
        kotlin.jvm.internal.r.e(strReplaceAll, "replaceAll(...)");
        return strReplaceAll;
    }

    public String toString() {
        String string = this.f6045a.toString();
        kotlin.jvm.internal.r.e(string, "toString(...)");
        return string;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public i(String pattern) {
        kotlin.jvm.internal.r.f(pattern, "pattern");
        Pattern patternCompile = Pattern.compile(pattern);
        kotlin.jvm.internal.r.e(patternCompile, "compile(...)");
        this(patternCompile);
    }
}
