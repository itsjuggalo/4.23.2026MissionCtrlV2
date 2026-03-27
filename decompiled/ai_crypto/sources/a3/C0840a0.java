package a3;

import android.app.Application;
import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.Recaptcha;

/* JADX INFO: renamed from: a3.a0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0840a0 implements InterfaceC0836X {
    @Override // a3.InterfaceC0836X
    public final Task a(Application application, String str) {
        return Recaptcha.fetchTaskClient(application, str);
    }
}
