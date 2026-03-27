package w3;

import java.io.IOException;
import java.util.BitSet;

/* JADX INFO: loaded from: classes.dex */
public class Z extends t3.s {
    @Override // t3.s
    public final Object b(B3.a aVar) throws IOException {
        boolean zR;
        BitSet bitSet = new BitSet();
        aVar.d();
        int iB = aVar.B();
        int i = 0;
        while (iB != 2) {
            int iC = S.i.c(iB);
            if (iC == 5 || iC == 6) {
                int iT = aVar.t();
                if (iT == 0) {
                    zR = false;
                } else {
                    if (iT != 1) {
                        StringBuilder sbO = a3.d.o("Invalid bitset value ", iT, ", expected 0 or 1; at path ");
                        sbO.append(aVar.n());
                        throw new t3.i(sbO.toString());
                    }
                    zR = true;
                }
            } else {
                if (iC != 7) {
                    throw new t3.i("Invalid bitset value type: " + k0.a.j(iB) + "; at path " + aVar.l());
                }
                zR = aVar.r();
            }
            if (zR) {
                bitSet.set(i);
            }
            i++;
            iB = aVar.B();
        }
        aVar.i();
        return bitSet;
    }

    @Override // t3.s
    public final void c(B3.b bVar, Object obj) throws IOException {
        BitSet bitSet = (BitSet) obj;
        bVar.f();
        int length = bitSet.length();
        for (int i = 0; i < length; i++) {
            bVar.s(bitSet.get(i) ? 1L : 0L);
        }
        bVar.i();
    }
}
