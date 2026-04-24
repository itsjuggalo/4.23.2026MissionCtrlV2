package v5;

import G4.l;
import R4.p;
import java.io.IOException;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.s;
import u5.y;

/* JADX INFO: loaded from: classes.dex */
public final class g extends k implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f10672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s f10673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ s f10674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ s f10675d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(y yVar, s sVar, s sVar2, s sVar3) {
        super(2);
        this.f10672a = yVar;
        this.f10673b = sVar;
        this.f10674c = sVar2;
        this.f10675d = sVar3;
    }

    @Override // R4.p
    public final Object invoke(Object obj, Object obj2) throws IOException {
        int iIntValue = ((Number) obj).intValue();
        long jLongValue = ((Number) obj2).longValue();
        if (iIntValue == 21589) {
            if (jLongValue < 1) {
                throw new IOException("bad zip: extended timestamp extra too short");
            }
            y yVar = this.f10672a;
            byte bD = yVar.d();
            boolean z6 = (bD & 1) == 1;
            boolean z7 = (bD & 2) == 2;
            boolean z8 = (bD & 4) == 4;
            long j4 = z6 ? 5L : 1L;
            if (z7) {
                j4 += 4;
            }
            if (z8) {
                j4 += 4;
            }
            if (jLongValue < j4) {
                throw new IOException("bad zip: extended timestamp extra too short");
            }
            if (z6) {
                this.f10673b.f7934a = Long.valueOf(((long) yVar.i()) * 1000);
            }
            if (z7) {
                this.f10674c.f7934a = Long.valueOf(((long) yVar.i()) * 1000);
            }
            if (z8) {
                this.f10675d.f7934a = Long.valueOf(((long) yVar.i()) * 1000);
            }
        }
        return l.f540a;
    }
}
