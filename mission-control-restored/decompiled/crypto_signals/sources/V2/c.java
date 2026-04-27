package V2;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements X2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f3240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f3241c;

    public /* synthetic */ c(int i, Context context, String str) {
        this.f3239a = i;
        this.f3240b = context;
        this.f3241c = str;
    }

    @Override // X2.b
    public final Object get() {
        switch (this.f3239a) {
            case 0:
                return new l(this.f3240b, this.f3241c);
            default:
                return this.f3240b.getSharedPreferences(this.f3241c, 0);
        }
    }
}
