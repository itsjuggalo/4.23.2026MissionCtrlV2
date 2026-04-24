package r3;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f14595b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pattern f14596a;

    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public a() {
        }
    }

    public k(Pattern nativePattern) {
        kotlin.jvm.internal.r.f(nativePattern, "nativePattern");
        this.f14596a = nativePattern;
    }

    public final InterfaceC1761h a(CharSequence input) {
        kotlin.jvm.internal.r.f(input, "input");
        Matcher matcher = this.f14596a.matcher(input);
        kotlin.jvm.internal.r.e(matcher, "matcher(...)");
        return l.c(matcher, input);
    }

    public final boolean b(CharSequence input) {
        kotlin.jvm.internal.r.f(input, "input");
        return this.f14596a.matcher(input).matches();
    }

    public final String c(CharSequence input, String replacement) {
        kotlin.jvm.internal.r.f(input, "input");
        kotlin.jvm.internal.r.f(replacement, "replacement");
        String strReplaceAll = this.f14596a.matcher(input).replaceAll(replacement);
        kotlin.jvm.internal.r.e(strReplaceAll, "replaceAll(...)");
        return strReplaceAll;
    }

    public String toString() {
        String string = this.f14596a.toString();
        kotlin.jvm.internal.r.e(string, "toString(...)");
        return string;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public k(String pattern) {
        kotlin.jvm.internal.r.f(pattern, "pattern");
        Pattern patternCompile = Pattern.compile(pattern);
        kotlin.jvm.internal.r.e(patternCompile, "compile(...)");
        this(patternCompile);
    }
}
