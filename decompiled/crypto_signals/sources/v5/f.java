package v5;

import G4.l;
import R4.p;
import java.io.IOException;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.r;
import u5.y;

/* JADX INFO: loaded from: classes.dex */
public final class f extends k implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.p f10667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f10668b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ r f10669c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ y f10670d;
    public final /* synthetic */ r e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ r f10671f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(kotlin.jvm.internal.p pVar, long j4, r rVar, y yVar, r rVar2, r rVar3) {
        super(2);
        this.f10667a = pVar;
        this.f10668b = j4;
        this.f10669c = rVar;
        this.f10670d = yVar;
        this.e = rVar2;
        this.f10671f = rVar3;
    }

    @Override // R4.p
    public final Object invoke(Object obj, Object obj2) throws IOException {
        int iIntValue = ((Number) obj).intValue();
        long jLongValue = ((Number) obj2).longValue();
        if (iIntValue == 1) {
            kotlin.jvm.internal.p pVar = this.f10667a;
            if (pVar.f7931a) {
                throw new IOException("bad zip: zip64 extra repeated");
            }
            pVar.f7931a = true;
            if (jLongValue < this.f10668b) {
                throw new IOException("bad zip: zip64 extra too short");
            }
            r rVar = this.f10669c;
            long j4 = rVar.f7933a;
            y yVar = this.f10670d;
            if (j4 == 4294967295L) {
                j4 = yVar.j();
            }
            rVar.f7933a = j4;
            r rVar2 = this.e;
            rVar2.f7933a = rVar2.f7933a == 4294967295L ? yVar.j() : 0L;
            r rVar3 = this.f10671f;
            rVar3.f7933a = rVar3.f7933a == 4294967295L ? yVar.j() : 0L;
        }
        return l.f540a;
    }
}
