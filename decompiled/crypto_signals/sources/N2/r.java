package N2;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class r implements OnSuccessListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f2039b;

    public /* synthetic */ r(int i, TaskCompletionSource taskCompletionSource) {
        this.f2038a = i;
        this.f2039b = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object obj) {
        switch (this.f2038a) {
            case 0:
                this.f2039b.setResult((Map) obj);
                break;
            default:
                this.f2039b.setResult(obj);
                break;
        }
    }
}
