package N3;

import Y3.h;
import Z3.s;
import android.content.Intent;
import dev.fluttercommunity.plus.share.SharePlusPendingIntent;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class c implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f2068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AtomicBoolean f2069b;

    @Override // Z3.s
    public final boolean onActivityResult(int i, int i6, Intent intent) {
        h hVar;
        if (i != 22643) {
            return false;
        }
        String str = SharePlusPendingIntent.f6036a;
        if (this.f2069b.compareAndSet(false, true) && (hVar = this.f2068a) != null) {
            hVar.c(str);
            this.f2068a = null;
        }
        return true;
    }
}
