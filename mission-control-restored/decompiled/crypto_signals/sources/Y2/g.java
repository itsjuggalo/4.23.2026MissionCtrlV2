package Y2;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public final class g implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f3608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TaskCompletionSource f3609b;

    public g(k kVar, TaskCompletionSource taskCompletionSource) {
        this.f3608a = kVar;
        this.f3609b = taskCompletionSource;
    }

    @Override // Y2.j
    public final boolean a(Z2.b bVar) {
        if (bVar.f3993b != 4 || this.f3608a.a(bVar)) {
            return false;
        }
        String str = bVar.f3994c;
        if (str == null) {
            throw new NullPointerException("Null token");
        }
        this.f3609b.setResult(new a(str, bVar.e, bVar.f3996f));
        return true;
    }

    @Override // Y2.j
    public final boolean b(Exception exc) {
        this.f3609b.trySetException(exc);
        return true;
    }
}
