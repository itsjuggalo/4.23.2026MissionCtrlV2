package z3;

import java.sql.Timestamp;
import java.util.Date;
import w3.AbstractC1287g;

/* JADX INFO: renamed from: z3.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1470e extends AbstractC1287g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f11764b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1470e(Class cls, int i) {
        super(cls);
        this.f11764b = i;
    }

    @Override // w3.AbstractC1287g
    public final Date a(Date date) {
        switch (this.f11764b) {
            case 0:
                return new java.sql.Date(date.getTime());
            default:
                return new Timestamp(date.getTime());
        }
    }
}
