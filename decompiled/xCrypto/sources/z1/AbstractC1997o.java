package z1;

import android.content.Intent;

/* JADX INFO: renamed from: z1.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1997o extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Intent f16113a;

    public AbstractC1997o(String str, Intent intent) {
        super(str);
        this.f16113a = intent;
    }

    public Intent a() {
        return new Intent(this.f16113a);
    }
}
