package r3;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import o3.AbstractC1681l;
import o3.C1676g;

/* JADX INFO: loaded from: classes3.dex */
public abstract class l {
    public static final InterfaceC1761h c(Matcher matcher, CharSequence charSequence) {
        if (matcher.matches()) {
            return new C1762i(matcher, charSequence);
        }
        return null;
    }

    public static final C1676g d(MatchResult matchResult, int i4) {
        return AbstractC1681l.l(matchResult.start(i4), matchResult.end(i4));
    }
}
