package w3;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class I extends t3.s {
    @Override // t3.s
    public final Object b(B3.a aVar) throws IOException {
        if (aVar.B() == 9) {
            aVar.x();
            return null;
        }
        String strZ = aVar.z();
        if (strZ.length() == 1) {
            return Character.valueOf(strZ.charAt(0));
        }
        StringBuilder sbP = a3.d.p("Expecting character, got: ", strZ, "; at ");
        sbP.append(aVar.n());
        throw new t3.i(sbP.toString());
    }

    @Override // t3.s
    public final void c(B3.b bVar, Object obj) throws IOException {
        Character ch = (Character) obj;
        bVar.v(ch == null ? null : String.valueOf(ch));
    }
}
