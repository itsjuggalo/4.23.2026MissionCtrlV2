package P1;

import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public abstract class o extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Intent f4316a;

    public o(String str, Intent intent) {
        super(str);
        this.f4316a = intent;
    }

    public Intent a() {
        return new Intent(this.f4316a);
    }
}
