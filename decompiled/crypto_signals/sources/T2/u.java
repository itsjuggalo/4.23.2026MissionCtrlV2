package T2;

import a.AbstractC0284a;
import com.google.android.gms.tasks.Tasks;
import s1.C0994k;
import v4.C1260a;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w2.c f3006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C1260a f3007c;

    public /* synthetic */ u(w2.c cVar, C1260a c1260a, int i) {
        this.f3005a = i;
        this.f3006b = cVar;
        this.f3007c = c1260a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3005a) {
            case 0:
                this.f3006b.h(this.f3007c);
                break;
            case 1:
                w2.c cVar = this.f3006b;
                cVar.getClass();
                AbstractC0284a.f(1, "GrpcCallProvider", "connectivityAttemptTimer elapsed. Resetting the channel.", new Object[0]);
                if (((C0994k) cVar.f10726d) != null) {
                    AbstractC0284a.f(1, "GrpcCallProvider", "Clearing the connectivityAttemptTimer", new Object[0]);
                    ((C0994k) cVar.f10726d).C();
                    cVar.f10726d = null;
                }
                ((U2.f) cVar.f10724b).a(new u(cVar, this.f3007c, 4));
                break;
            case 2:
                w2.c cVar2 = this.f3006b;
                cVar2.getClass();
                ((U2.f) cVar2.f10724b).a(new u(cVar2, this.f3007c, 3));
                break;
            case 3:
                this.f3006b.h(this.f3007c);
                break;
            default:
                w2.c cVar3 = this.f3006b;
                cVar3.getClass();
                this.f3007c.z();
                cVar3.f10723a = Tasks.call(U2.l.f3159c, new t(cVar3, 0));
                break;
        }
    }
}
