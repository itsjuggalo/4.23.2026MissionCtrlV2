package z3;

import java.sql.Timestamp;
import java.util.Date;
import t3.s;
import t3.t;

/* JADX INFO: renamed from: z3.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1468c implements t {
    @Override // t3.t
    public final s create(t3.e eVar, A3.a aVar) {
        if (aVar.f61a != Timestamp.class) {
            return null;
        }
        eVar.getClass();
        return new C1469d(eVar.c(new A3.a(Date.class)));
    }
}
