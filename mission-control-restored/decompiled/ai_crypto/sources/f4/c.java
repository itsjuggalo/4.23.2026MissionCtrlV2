package f4;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c extends e {
    public c(e4.h hVar, Q2.g gVar, long j7) {
        super(hVar, gVar);
        if (j7 != 0) {
            super.G("Range", "bytes=" + j7 + "-");
        }
    }

    @Override // f4.e
    public String e() {
        return "GET";
    }

    @Override // f4.e
    public Map l() {
        return Collections.singletonMap("alt", "media");
    }
}
