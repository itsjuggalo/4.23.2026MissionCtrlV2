package V6;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes2.dex */
public abstract class o {
    public static final k c(Matcher matcher, CharSequence charSequence) {
        if (matcher.matches()) {
            return new l(matcher, charSequence);
        }
        return null;
    }

    public static final H5.d d(MatchResult matchResult, int i8) {
        return H5.i.l(matchResult.start(i8), matchResult.end(i8));
    }
}
