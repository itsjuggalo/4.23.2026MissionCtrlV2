package kg;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class n implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f14920b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pattern f14921a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    public n(Pattern nativePattern) {
        kotlin.jvm.internal.t.f(nativePattern, "nativePattern");
        this.f14921a = nativePattern;
    }

    public final k a(CharSequence input) {
        kotlin.jvm.internal.t.f(input, "input");
        Matcher matcher = this.f14921a.matcher(input);
        kotlin.jvm.internal.t.e(matcher, "matcher(...)");
        return o.c(matcher, input);
    }

    public final boolean b(CharSequence input) {
        kotlin.jvm.internal.t.f(input, "input");
        return this.f14921a.matcher(input).matches();
    }

    public final String c(CharSequence input, String replacement) {
        kotlin.jvm.internal.t.f(input, "input");
        kotlin.jvm.internal.t.f(replacement, "replacement");
        String strReplaceAll = this.f14921a.matcher(input).replaceAll(replacement);
        kotlin.jvm.internal.t.e(strReplaceAll, "replaceAll(...)");
        return strReplaceAll;
    }

    public String toString() {
        String string = this.f14921a.toString();
        kotlin.jvm.internal.t.e(string, "toString(...)");
        return string;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public n(String pattern) {
        kotlin.jvm.internal.t.f(pattern, "pattern");
        Pattern patternCompile = Pattern.compile(pattern);
        kotlin.jvm.internal.t.e(patternCompile, "compile(...)");
        this(patternCompile);
    }
}
