package Y4;

import java.io.Serializable;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pattern f3694a;

    public c(String str) {
        Pattern patternCompile = Pattern.compile(str);
        kotlin.jvm.internal.j.d(patternCompile, "compile(...)");
        this.f3694a = patternCompile;
    }

    public final String toString() {
        String string = this.f3694a.toString();
        kotlin.jvm.internal.j.d(string, "toString(...)");
        return string;
    }
}
