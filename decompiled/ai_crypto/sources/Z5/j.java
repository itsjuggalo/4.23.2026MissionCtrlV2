package Z5;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j {
    public static final g c(Matcher matcher, CharSequence charSequence) {
        if (matcher.matches()) {
            return new h(matcher, charSequence);
        }
        return null;
    }

    public static final W5.g d(MatchResult matchResult, int i7) {
        return W5.l.l(matchResult.start(i7), matchResult.end(i7));
    }
}
