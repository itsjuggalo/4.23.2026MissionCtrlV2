package w3;

import java.io.IOException;
import java.util.Locale;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes.dex */
public class X extends t3.s {
    @Override // t3.s
    public final Object b(B3.a aVar) throws IOException {
        if (aVar.B() == 9) {
            aVar.x();
            return null;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(aVar.z(), "_");
        String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        return (strNextToken2 == null && strNextToken3 == null) ? new Locale(strNextToken) : strNextToken3 == null ? new Locale(strNextToken, strNextToken2) : new Locale(strNextToken, strNextToken2, strNextToken3);
    }

    @Override // t3.s
    public final void c(B3.b bVar, Object obj) throws IOException {
        Locale locale = (Locale) obj;
        bVar.v(locale == null ? null : locale.toString());
    }
}
