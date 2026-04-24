package S1;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import l2.C2329m;

/* JADX INFO: loaded from: classes.dex */
public abstract class Q extends G {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2329m f7371b;

    public Q(int i8, C2329m c2329m) {
        super(i8);
        this.f7371b = c2329m;
    }

    @Override // S1.U
    public final void a(Status status) {
        this.f7371b.d(new R1.b(status));
    }

    @Override // S1.U
    public final void b(Exception exc) {
        this.f7371b.d(exc);
    }

    @Override // S1.U
    public final void c(C0892y c0892y) throws DeadObjectException {
        try {
            h(c0892y);
        } catch (DeadObjectException e8) {
            a(U.e(e8));
            throw e8;
        } catch (RemoteException e9) {
            a(U.e(e9));
        } catch (RuntimeException e10) {
            this.f7371b.d(e10);
        }
    }

    public abstract void h(C0892y c0892y);
}
